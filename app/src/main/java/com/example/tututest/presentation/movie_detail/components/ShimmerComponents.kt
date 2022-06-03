package com.example.tututest.presentation.movie_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.tututest.ui.theme.BackgroundColor

@Composable
fun ShimmerComponents(
    brush: Brush
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Постер
        ShimmerItem(brush = brush, width = 200, height = 320, paddingBottom = 0, paddingTop = 93, rounded = 10)
        Column(
            modifier = Modifier
                .offset(y = (-15).dp)
                .clip(RoundedCornerShape(15.dp))
                .background(BackgroundColor)
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Название
            ShimmerItem(brush = brush, width = 200, height = 27, paddingBottom = 15, paddingTop = 25, rounded = 100)
            // Альтернативное название
            ShimmerItem(brush = brush, width = 100, height = 10, paddingBottom = 15, paddingTop = 0, rounded = 100)
            // Год, Страна, Жанры
            ShimmerItem(brush = brush, width = 230, height = 10, paddingBottom = 8, paddingTop = 0, rounded = 100)
            ShimmerItem(brush = brush, width = 200, height = 10, paddingBottom = 27, paddingTop = 0, rounded = 100)
            // Описание
            for(i in 1..5){
                ShimmerItem(brush = brush, width = 600, height = 11, paddingBottom = 10, paddingTop = 0, rounded = 100)
            }
        }
    }
}
