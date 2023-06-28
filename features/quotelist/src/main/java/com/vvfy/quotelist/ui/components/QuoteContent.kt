package com.vvfy.quotelist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import com.vvfy.coreui.R
import com.vvfy.coreui.components.QuicksandText
import com.vvfy.quotelist.ui.vo.QuoteWithColor

@Composable
fun QuoteContent(
    quote: QuoteWithColor,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color = colorResource(id = quote.backgroundColor))
    ) {
        val arrangementModifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = dimensionResource(id = R.dimen.quote_side_spacing))

        QuicksandText(
            text = quote.quote,
            textAlign = TextAlign.Center,
            fontSize = dimensionResource(id = R.dimen.text_size_H1).value.sp,
            color = MaterialTheme.colors.primary,
            modifier = arrangementModifier
        )

        QuicksandText(
            text = stringResource(id = com.vvfy.quotelist.R.string.author, quote.author),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            modifier = arrangementModifier
                .padding(top = dimensionResource(id = R.dimen.space_20))
        )
    }
}