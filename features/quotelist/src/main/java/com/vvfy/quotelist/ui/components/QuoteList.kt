package com.vvfy.quotelist.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vvfy.quotelist.ui.vo.QuoteWithColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuoteList(
    list: List<QuoteWithColor>,
    modifier: Modifier = Modifier
) {
    VerticalPager(
        modifier = modifier,
        pageCount = list.size,
    ) {
        QuoteContent(
            quote = list[it],
            modifier = Modifier.fillMaxSize()
        )
    }
}