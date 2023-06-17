package com.vvfy.data.di

import com.vvfy.data.remote.source.QuoteRemoteSource
import com.vvfy.data.remote.source.QuoteRemoteSourceImpl
import com.vvfy.data.repository.QuoteRepositoryImpl
import com.vvfy.domain.repository.QuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatasourceModule {

    @Singleton
    @Binds
    abstract fun bindQuoteNetworkDataSource(dataSource: QuoteRemoteSourceImpl): QuoteRemoteSource

}