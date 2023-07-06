package com.vvfy.quotes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vvfy.quotes.navigation.AppNavHost

@Composable
fun QuoteAppContent() {
    val navController: NavHostController = rememberNavController()
    AppNavHost(navController)
}
