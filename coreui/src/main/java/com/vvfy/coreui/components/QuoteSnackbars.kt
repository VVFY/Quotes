package com.vvfy.coreui.components

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.vvfy.coreui.Message

@Composable
fun PlainSnackbar(
    modifier: Modifier = Modifier,
    message: Message?,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    onSnackbarShown: () -> Unit
) {
    LaunchedEffect(message) {
        message?.message?.let {
            snackbarHostState.showSnackbar(it, "", duration = SnackbarDuration.Short)
            onSnackbarShown()
        }
    }
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = modifier
    )
}
