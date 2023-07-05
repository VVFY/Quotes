package com.vvfy.quotelist.ui

import com.vvfy.coreui.Message
import com.vvfy.coreui.UiState
import com.vvfy.quotelist.ui.vo.QuoteWithColor

data class QuoteScreenState(
    override val isLoading: Boolean = false,
    val quoteList: List<QuoteWithColor> = emptyList(),
    override val error: Message? = null
): UiState()