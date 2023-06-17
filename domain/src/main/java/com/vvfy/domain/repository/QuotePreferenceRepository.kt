package com.vvfy.domain.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface QuotePreferenceRepository {

    suspend fun putLong(key: String, value: Long)
    fun getLong(key: String): Flow<Long?>
}