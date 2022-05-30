package com.example.tututest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.tututest.models.movie.Person
import com.example.tututest.ui.theme.BackgroundColor

@Composable
fun PersonItem(person: Person) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 20.dp, bottom = 10.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = person.photo
            ),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                //.padding(top = 3.dp, start = 3.dp, end = 3.dp)
                .padding(end = 5.dp)
                .fillMaxHeight()
                //.border(width = 1.dp, color = BorderColor)
                .clip(RoundedCornerShape(5.dp))
                .size(width = 43.dp, height = 50.dp)
                .align(Alignment.CenterVertically)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                //.background(ItemColor)
                .padding(horizontal = 10.dp, vertical = 0.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = person.name + "",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = person.enName + "",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 13.sp,
            )
        }
    }
}