package com.vvfy.coreui.navigation

/**
 * Unique root for destinations defined in nav graphs.
 * For unique roots to graph, visit [Root]
 */
sealed class Destinations(val route: String, val name: String) {
    object Splash : Destinations("splash", "Start")
    object QuoteList : Destinations("quotelist", "Quotes")
}