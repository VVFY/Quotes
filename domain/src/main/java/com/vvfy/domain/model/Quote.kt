package com.vvfy.domain.model

import com.vvfy.domain.QuoteColor

/**
 * External data model for quote
 */
data class Quote(
    val id: Long,
    val quote: String,
    val author: String,
    val backgroundColor: QuoteColor
)
