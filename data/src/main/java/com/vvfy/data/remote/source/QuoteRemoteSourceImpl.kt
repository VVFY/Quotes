package com.vvfy.data.remote.source

import com.vvfy.data.remote.dto.QuoteDto
import com.vvfy.data.remote.service.QuoteService
import retrofit2.Response
import javax.inject.Inject

class QuoteRemoteSourceImpl @Inject constructor(
    private val quoteService: QuoteService
): QuoteRemoteSource {

    override suspend fun fetchRandomQuotes(): Response<List<QuoteDto>> {
        return quoteService.getRandomQuotes()
    }

}