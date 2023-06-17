package com.vvfy.quotelist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vvfy.coreui.toEvent
import com.vvfy.domain.usecase.GetQuoteListUseCase
import com.vvfy.domain.usecase.RefreshQuoteListUseCase
import com.vvfy.quotelist.utils.toQuotesWithColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteListUseCase: GetQuoteListUseCase,
    private val refreshQuoteListUseCase: RefreshQuoteListUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<QuoteScreenState> = MutableStateFlow(QuoteScreenState())
    val state: StateFlow<QuoteScreenState> = _state

    private var quotesJob: Job? = null

    init {
        refreshQuotes()
        getQuoteList()
    }

    fun refreshQuotes(forceRefresh: Boolean = false) {
        if (quotesJob?.isActive == true) return
        viewModelScope
            .launch {
                _state.update { it.copy(isLoading = true) }
                refreshQuoteListUseCase(forceRefresh)
                    .onSuccess { _state.update { it.copy(isLoading = false) } }
                    .onError { t -> _state.update { it.copy(isLoading = false, error = t?.message.toEvent()) } }
            }
            .also { quotesJob = it }
    }

    private fun getQuoteList() {
        getQuoteListUseCase()
            .map { it.toQuotesWithColor() }
            .onEach { list -> _state.update { it.copy(quoteList = list) } }
            .launchIn(viewModelScope)
    }
}

