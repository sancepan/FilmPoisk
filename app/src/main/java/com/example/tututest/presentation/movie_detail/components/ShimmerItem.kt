package com.example.tututest.presentation.movie_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerItem(
    brush: Brush,
    width: Int,
    height: Int,
    paddingBottom: Int,
    paddingTop: Int,
    rounded: Int,

    ){
    Spacer(
        modifier = Modifier
            .padding(top = paddingTop.dp, bottom = paddingBottom.dp)
            .clip(RoundedCornerShape(rounded.dp))
            .size(height = height.dp, width = width.dp)
            .background(brush = brush)
    )
}