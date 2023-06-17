package com.vvfy.data.di

import android.content.Context
import androidx.room.Room
import com.vvfy.data.local.dao.QuoteDao
import com.vvfy.data.local.db.AppDatabase
import com.vvfy.data.remote.service.QuoteService
import com.vvfy.data.repository.QuoteRepositoryImpl
import com.vvfy.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDB(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteDAO(appDatabase: AppDatabase): QuoteDao {
        return appDatabase.quoteDao()
    }
}