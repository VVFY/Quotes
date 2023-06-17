package com.vvfy.data.remote.source

import com.vvfy.data.remote.dto.QuoteDto
import retrofit2.Response
import javax.inject.Singleton

@Singleton
interface QuoteRemoteSource {
    suspend fun fetchRandomQuotes(): Response<List<QuoteDto>>
}