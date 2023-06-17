package com.vvfy.domain.usecase

import com.vvfy.domain.model.NullableWrapper
import com.vvfy.domain.repository.QuotePreferenceRepository
import com.vvfy.domain.repository.QuoteRepository
import com.vvfy.domain.repository.Response
import kotlinx.coroutines.flow.first
import java.util.Calendar
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RefreshQuoteListUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository,
    private val preferenceRepository: QuotePreferenceRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false): Response<NullableWrapper<Unit>> {
        if (forceRefresh) {
            return syncNewQuotes()
        }
        return preferenceRepository.getLong(KEY_LAST_REFRESH_TIME).first()
            ?.let { lastRefreshTime ->
                val diff = lastRefreshTime - Calendar.getInstance().timeInMillis
                val hourDiff = TimeUnit.MILLISECONDS.toHours(diff)
                if (hourDiff > 1) {
                    return syncNewQuotes()
                }
                Response.success(NullableWrapper())
            } ?: kotlin.run { syncNewQuotes() }
    }

    private suspend fun syncNewQuotes(): Response<NullableWrapper<Unit>> {
        return quoteRepository.syncNewQuotes()
            .onSuccess {
                preferenceRepository.putLong(
                    KEY_LAST_REFRESH_TIME,
                    Calendar.getInstance().timeInMillis
                )
            }
    }

    companion object {
        private const val KEY_LAST_REFRESH_TIME = "last-refresh-time"
    }
}