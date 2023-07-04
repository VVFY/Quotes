package com.vvfy.coreui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightColorPalette = lightColors(
    primary = white,
    primaryVariant = whitePorcelain,
    secondary = royalPurple,
    secondaryVariant = northwesternPurple,
    background = roseWhite,
    surface = roseWhite,
    error = red200,
    onPrimary = black,
    onBackground = black,
    onSurface = black
)


@Composable
fun QuotesTheme(
    darkTheme: Boolean = false, //Can be isSystemInDarkTheme(), if need to support
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = lightColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
