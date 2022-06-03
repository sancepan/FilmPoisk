package com.example.tututest.presentation.movie_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tututest.ui.theme.BackgroundColor

@Composable
fun Header(text: String){
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .padding(horizontal = 13.dp, vertical = 8.dp),
        color = Color.White,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,)
}