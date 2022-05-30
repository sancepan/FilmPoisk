package com.example.tututest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tututest.ui.theme.ItemColor

@Composable
fun RatingItem(rating: Double, name: String, votes: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(ItemColor)
            .padding(vertical = 15.dp, horizontal = 15.dp)
    ) {
        Text(
            text = rating.toString(),
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(end = 15.dp)
        )
        Column() {
            Text(
                text = name,
                fontSize = 13.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(
                text = "$votes оценок",
                fontSize = 13.sp,
                color = Color.White.copy(alpha = 0.5f),
            )
        }
    }
}