package com.vvfy.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.vvfy.domain.repository.QuotePreferenceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuotePreferenceRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): QuotePreferenceRepository {

    override suspend fun putLong(key: String, value: Long) {
        dataStore.edit { pref ->
            pref[longPreferencesKey(key)] = value
        }
    }

    override fun getLong(key: String): Flow<Long?> {
        return dataStore.data.map { pref ->
            pref[longPreferencesKey(key)]
        }
    }
}