package com.vvfy.quotes.splash

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.google.accompanist.themeadapter.material.MdcTheme
import com.vvfy.coreui.BaseFragment
import com.vvfy.coreui.DeepLinks
import com.vvfy.coreui.viewBinding
import com.vvfy.quotes.R
import com.vvfy.quotes.databinding.SplashFragmentBinding
import com.vvfy.quotes.splash.components.SplashScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.splash_fragment) {
    private val binding by viewBinding { SplashFragmentBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.composeSplashRoot) {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MdcTheme {
                    SplashScreen(::navigateToQuote)
                }
            }
        }
    }

    private fun navigateToQuote() {
        findNavController().navigate(
            DeepLinks.QUOTE_FRAGMENT,
            NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
        )
    }

}