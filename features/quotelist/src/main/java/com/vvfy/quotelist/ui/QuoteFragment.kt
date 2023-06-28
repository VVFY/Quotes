package com.vvfy.quotelist.ui

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.themeadapter.material.MdcTheme
import com.vvfy.coreui.BaseFragment
import com.vvfy.coreui.viewBinding
import com.vvfy.quotelist.R
import com.vvfy.quotelist.databinding.QuoteFragmentBinding
import com.vvfy.quotelist.ui.components.QuoteScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class QuoteFragment : BaseFragment(R.layout.quote_fragment) {

    private val binding by viewBinding { QuoteFragmentBinding.bind(it) }
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        quoteViewModel.state
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { publishState(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun publishState(state: QuoteScreenState) {
        with(binding.composeQuoteRoot) {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MdcTheme {
                    QuoteScreen(viewModel = quoteViewModel)
                }
            }
        }
        state.error?.showSnackBar()
    }
}