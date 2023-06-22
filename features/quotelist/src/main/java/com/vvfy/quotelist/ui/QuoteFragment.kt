package com.vvfy.quotelist.ui

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.ui.Modifier
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.vvfy.coreui.BaseFragment
import com.vvfy.coreui.applySystemWindowInsetToMargin
import com.vvfy.coreui.hyperlink
import com.vvfy.coreui.viewBinding
import com.vvfy.quotelist.R
import com.vvfy.quotelist.databinding.QuoteFragmentBinding
import com.vvfy.quotelist.ui.components.QuoteContent
import com.vvfy.quotelist.ui.components.QuoteList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class QuoteFragment : BaseFragment(R.layout.quote_fragment) {

    private val binding by viewBinding { QuoteFragmentBinding.bind(it) }
    private val quoteViewModel: QuoteViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyInsets()
        binding.refresh.setOnClickListener { quoteViewModel.refreshQuotes(true) }
        binding.attribution.hyperlink(R.string.zenquotes_io)
        observeData()
    }

    private fun applyInsets() {
        binding.refresh.applySystemWindowInsetToMargin(top = true)
        binding.progressBar.applySystemWindowInsetToMargin(top = true)
        binding.attribution.applySystemWindowInsetToMargin(bottom = true)
    }

    private fun observeData() {
        quoteViewModel.state
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { publishState(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun publishState(state: QuoteScreenState) {
        binding.progressBar.isVisible = state.isLoading
        binding.refresh.isVisible = !state.isLoading
        with(binding.composeQuoteView) {
            setContent {
                QuoteList(
                    list = state.quoteList,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        state.error?.showSnackBar()
    }
}