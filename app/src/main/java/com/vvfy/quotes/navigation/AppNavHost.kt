package com.vvfy.quotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvfy.coreui.navigation.Destinations
import com.vvfy.coreui.navigation.Root
import com.vvfy.quotelist.navigation.quoteListGraph
import com.vvfy.quotes.splash.components.SplashScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.Splash.route) {
        composable(route = Destinations.Splash.route) {
            SplashScreen(
                onNavigateToQuotes = {
                    navController.navigate(Root.QuoteList.route) {
                        popUpTo(Destinations.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        quoteListGraph(navController)
    }
}