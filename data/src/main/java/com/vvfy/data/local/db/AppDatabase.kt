package com.vvfy.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vvfy.data.local.dao.QuoteDao
import com.vvfy.data.local.entity.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        const val DB_NAME = "quotes_db"
    }
}
