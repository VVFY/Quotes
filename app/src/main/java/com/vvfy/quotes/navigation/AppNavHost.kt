package com.vvfy.quotes.navigation

import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.vvfy.coreui.navigation.DeepLinks
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
                    navController.navigate(
                        deepLink = DeepLinks.quoteList.toUri(),
                        navOptions = navOptions {
                            popUpTo(Destinations.Splash.route) {
                                inclusive = true
                            }
                        }
                    )
                }
            )
        }

        quoteListGraph(navController)
    }
}