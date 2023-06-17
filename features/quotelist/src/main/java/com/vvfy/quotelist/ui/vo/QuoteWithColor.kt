package com.vvfy.quotelist.ui.vo

import androidx.annotation.ColorRes

data class QuoteWithColor(
    val id: Long,
    val quote: String,
    val author: String,
    @ColorRes val backgroundColor: Int
)
