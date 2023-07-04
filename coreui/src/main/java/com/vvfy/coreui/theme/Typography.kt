package com.vvfy.coreui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.vvfy.coreui.R

private val quickSand = FontFamily(
    Font(R.font.quicksand_light, FontWeight(300))
    //more font weights..
)

internal val typography = Typography(
    h6 = TextStyle(
        fontFamily = quickSand,
        fontWeight = FontWeight.W300
    )
    //more customizations..
)