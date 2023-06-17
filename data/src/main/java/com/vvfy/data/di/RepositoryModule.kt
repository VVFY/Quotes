package com.vvfy.data.di

import com.vvfy.data.repository.QuotePreferenceRepositoryImpl
import com.vvfy.data.repository.QuoteRepositoryImpl
import com.vvfy.domain.repository.QuotePreferenceRepository
import com.vvfy.domain.repository.QuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindQuoteRepository(repository: QuoteRepositoryImpl): QuoteRepository

    @Binds
    fun bindQuotePreferenceRepository(repository: QuotePreferenceRepositoryImpl): QuotePreferenceRepository
}