package com.vvfy.quotelist.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vvfy.coreui.navigation.Destinations
import com.vvfy.coreui.navigation.Root
import com.vvfy.quotelist.ui.components.QuoteScreen

fun NavGraphBuilder.quoteListGraph(navController: NavController) {
    navigation(startDestination = Destinations.QuoteList.route, route = Root.QuoteList.route) {
        composable(Destinations.QuoteList.route) {
            QuoteScreen(viewModel = hiltViewModel())
        }
    }
}