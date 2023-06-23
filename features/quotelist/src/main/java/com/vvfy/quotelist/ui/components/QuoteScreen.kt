package com.vvfy.quotelist.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vvfy.coreui.clickableText
import com.vvfy.coreui.components.ClickableUrlText
import com.vvfy.quotelist.R
import com.vvfy.quotelist.ui.QuoteViewModel

@Composable
fun QuoteScreen(
    viewModel: QuoteViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val attribution by remember {
        mutableStateOf(
            clickableText(
                prefix = context.getString(R.string.quotes_provider_prefix),
                urlText = context.getString(R.string.quotes_provider),
                url = context.getString(R.string.quotes_provider_url)
            )
        )
    }
    Box(modifier = modifier) {
        QuoteList(
            list = uiState.quoteList,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
        ) {
            AnimatedVisibility(visible = uiState.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }

            if (!uiState.isLoading) {
                IconButton(
                    onClick = { viewModel.refreshQuotes(true) },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_refresh),
                        contentDescription = "Refresh",
                        tint = colorResource(id = com.vvfy.coreui.R.color.color_white),
                        modifier = Modifier
                            .size(40.dp)
                            .padding(8.dp)
                    )
                }
            }
        }

        ClickableUrlText(
            annotatedString = attribution,
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.navigationBars)
                .align(Alignment.BottomEnd)
                .padding(end = 8.dp, bottom = 20.dp)
        )
    }
}