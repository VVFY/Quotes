package com.vvfy.data.converters

import com.vvfy.data.local.entity.QuoteEntity
import com.vvfy.data.remote.dto.QuoteDto
import com.vvfy.domain.QuoteColor
import com.vvfy.domain.model.Quote
import retrofit2.Response


fun List<QuoteEntity>.toQuotes() = map(QuoteEntity::toQuote)
fun List<QuoteDto>.toQuoteEntities() = map(QuoteDto::toQuoteEntity)

fun QuoteDto.toQuoteEntity() = QuoteEntity(
    id = 0,
    quote = quote,
    author = author,
    backgroundColor  = QuoteColor.values().random().name
)

fun QuoteEntity.toQuote() = Quote(
    id = id,
    quote = quote,
    author = author,
    backgroundColor = QuoteColor.valueOf(backgroundColor)
)
