package com.vvfy.coreui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.vvfy.coreui.R

private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val quickSandName = GoogleFont("Quicksand", false)

private val quickSandFamily = FontFamily(
    Font(googleFont = quickSandName, fontProvider = provider, weight = FontWeight.Light)
    //more..
)

internal val typography = Typography(
    h6 = TextStyle(
        fontFamily = quickSandFamily,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = quickSandFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
    )
    //more customizations..
)