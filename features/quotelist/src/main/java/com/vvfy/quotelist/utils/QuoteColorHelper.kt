package com.vvfy.quotelist.utils

import com.vvfy.domain.QuoteColor

fun QuoteColor.toColorRes(): Int {
    return when(this) {
        QuoteColor.PURPLE -> com.vvfy.coreui.R.color.color_purple_500
        QuoteColor.RED -> com.vvfy.coreui.R.color.color_red_500
        QuoteColor.PINK -> com.vvfy.coreui.R.color.color_pink_500
        QuoteColor.INDIGO -> com.vvfy.coreui.R.color.color_indigo_500
        QuoteColor.CYAN -> com.vvfy.coreui.R.color.color_cyan_500
        QuoteColor.TEAL -> com.vvfy.coreui.R.color.color_teal_500
        QuoteColor.ORANGE -> com.vvfy.coreui.R.color.color_orange_500
        QuoteColor.BROWN -> com.vvfy.coreui.R.color.color_brown_500
    }
}