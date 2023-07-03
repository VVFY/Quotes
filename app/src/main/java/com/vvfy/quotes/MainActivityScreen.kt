package com.vvfy.quotes

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.vvfy.quotes.databinding.ActivityMainBinding

@Composable
fun MainActivityContent() {
    AndroidViewBinding(ActivityMainBinding::inflate)
}
