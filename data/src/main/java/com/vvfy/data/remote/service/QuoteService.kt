package com.vvfy.data.remote.service

import com.vvfy.data.remote.dto.QuoteDto
import retrofit2.Response
import retrofit2.http.GET

interface QuoteService {

    @GET("api/quotes")
    suspend fun getRandomQuotes(): Response<List<QuoteDto>>
}