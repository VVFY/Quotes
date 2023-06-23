package com.vvfy.coreui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

fun clickableText(
    prefix: String = "",
    urlText: String,
    url: String,
    tag: String = "URL"
): AnnotatedString {
    return buildAnnotatedString {
        if (prefix.isNotBlank()) {
            append(prefix.plus(" "))
        }
        pushStringAnnotation(
            tag = tag,
            annotation = url
        )
        withStyle(
            style = SpanStyle(color = Color.Blue)
        ) {
            append(urlText)
        }
        pop()
    }
}