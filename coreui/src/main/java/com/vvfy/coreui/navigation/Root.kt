package com.vvfy.coreui.navigation

/**
 * Unique root for nav graph
 */
sealed class Root(val route: String) {
    object QuoteList : Root("quote-list-graph")
}