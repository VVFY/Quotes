package com.vvfy.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Internal data model for quote
 */
@Entity(tableName = "quotes")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val quote: String,
    val author: String,
    val backgroundColor: String
)