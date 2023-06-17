package com.vvfy.quotelist.utils

import com.vvfy.domain.model.Quote
import com.vvfy.quotelist.ui.vo.QuoteWithColor

fun List<Quote>.toQuotesWithColor() = map(Quote::toQuoteWithColor)

private fun Quote.toQuoteWithColor() = QuoteWithColor(
    id = id,
    quote = quote,
    author = author,
    backgroundColor = backgroundColor.toColorRes()
)