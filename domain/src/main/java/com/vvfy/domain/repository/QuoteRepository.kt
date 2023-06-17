package com.vvfy.domain.repository

import com.vvfy.domain.model.NullableWrapper
import com.vvfy.domain.model.Quote
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface QuoteRepository {

    fun getQuotes(): Flow<List<Quote>>
    suspend fun syncNewQuotes(): Response<NullableWrapper<Unit>>
}