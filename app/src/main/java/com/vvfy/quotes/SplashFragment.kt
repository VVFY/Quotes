package com.vvfy.quotes

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.vvfy.coreui.BaseFragment
import com.vvfy.coreui.DeepLinks
import com.vvfy.coreui.viewBinding
import com.vvfy.quotes.databinding.SplashFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment: BaseFragment(R.layout.splash_fragment) {
    private val binding by viewBinding { SplashFragmentBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            findNavController().navigate(
                DeepLinks.QUOTE_FRAGMENT,
                NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
            )
        }
    }
}