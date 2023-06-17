package com.vvfy.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Internal data model for quote
 */
data class QuoteDto(
    @Json(name = "q")
    val quote: String,
    @Json(name = "a")
    val author: String
)
