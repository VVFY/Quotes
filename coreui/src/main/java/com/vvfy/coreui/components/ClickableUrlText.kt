package com.vvfy.coreui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString

@Composable
fun ClickableUrlText(
    annotatedString: AnnotatedString,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    ClickableText(
        text = annotatedString,
        onClick = {
            annotatedString
                .getStringAnnotations(tag = "URL", start = it, end = it)
                .firstOrNull()
                ?.let { uriHandler.openUri(it.item) }
        },
        style = MaterialTheme.typography.body2,
        modifier = modifier
    )
}