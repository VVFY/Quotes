package com.vvfy.quotelist.ui

import com.vvfy.coreui.Event
import com.vvfy.coreui.UiState
import com.vvfy.quotelist.ui.vo.QuoteWithColor

data class QuoteScreenState(
    override val isLoading: Boolean = false,
    val quoteList: List<QuoteWithColor> = emptyList(),
    override val error: Event<String>? = null
): UiState()