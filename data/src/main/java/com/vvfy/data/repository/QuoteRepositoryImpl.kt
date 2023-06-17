package com.vvfy.data.repository

import com.vvfy.data.converters.toQuoteEntities
import com.vvfy.data.converters.toQuotes
import com.vvfy.data.di.DefaultDispatcher
import com.vvfy.data.local.dao.QuoteDao
import com.vvfy.data.remote.dto.QuoteDto
import com.vvfy.data.remote.source.QuoteRemoteSource
import com.vvfy.data.utils.handleNetworkException
import com.vvfy.data.utils.response
import com.vvfy.domain.model.NullableWrapper
import com.vvfy.domain.model.Quote
import com.vvfy.domain.repository.QuoteRepository
import com.vvfy.domain.repository.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteRemoteSource: QuoteRemoteSource,
    private val quoteLocalSource: QuoteDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) : QuoteRepository {

    override fun getQuotes(): Flow<List<Quote>> {
        return quoteLocalSource.loadAllQuotes()
            .map { quoteEntityList ->
                withContext(dispatcher) {
                    quoteEntityList.toQuotes()
                }
            }
    }

    override suspend fun syncNewQuotes(): Response<NullableWrapper<Unit>> {
        return runCatching {
            val response = quoteRemoteSource.fetchRandomQuotes().response()
            when (response) {
                is Response.Success -> {
                    withContext(dispatcher) {
                        quoteLocalSource.deleteAll()
                        quoteLocalSource.insertAll(response.data.toQuoteEntities())
                    }
                    Response.success(NullableWrapper<Unit>())
                }
                is Response.Error -> response
            }
        }.getOrElse {
            Response.error(handleNetworkException(it))
        }
    }
}