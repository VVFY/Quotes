package com.vvfy.domain.usecase

import com.vvfy.domain.model.Quote
import com.vvfy.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteListUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    operator fun invoke(): Flow<List<Quote>> {
        return quoteRepository.getQuotes()
    }
}