package com.vvfy.coreui

open class UiState(
    open val isLoading: Boolean = false,
    open val error: Message? = null
)