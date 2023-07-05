package com.vvfy.quotelist.ui

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.vvfy.coreui.BaseFragment
import com.vvfy.coreui.viewBinding
import com.vvfy.quotelist.R
import com.vvfy.quotelist.databinding.QuoteFragmentBinding
import com.vvfy.quotelist.ui.components.QuoteScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteFragment : BaseFragment(R.layout.quote_fragment) {

    private val binding by viewBinding { QuoteFragmentBinding.bind(it) }
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.composeQuoteRoot) {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                QuoteScreen(viewModel = quoteViewModel)
            }
        }
    }
}