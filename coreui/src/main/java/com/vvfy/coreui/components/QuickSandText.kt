package com.vvfy.coreui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.core.content.res.ResourcesCompat
import com.vvfy.coreui.R

@Composable
fun QuicksandText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified
) {
    val context = LocalContext.current
    val fontFamily = remember {
        FontFamily(
            ResourcesCompat.getFont(context, R.font.quicksand_light)!!
        )
    }
    Text(
        text = text,
        textAlign = textAlign,
        fontFamily = fontFamily,
        fontSize = fontSize,
        color = color,
        modifier = modifier,
    )
}
