package com.example.tututest.presentation.movie_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.tututest.domain.model.movieList.Movie

@Composable
fun MovieItem(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(3.dp)
            .clickable { onItemClick(movie) }
    ){
        Image(
            painter = rememberImagePainter(
                data = movie.poster
            ),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 5.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(10.dp))
                .size(width = 65.dp, height = 100.dp)
                .align(Alignment.CenterVertically)

        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                //.background(ItemColor)
                .padding(horizontal = 10.dp, vertical = 0.dp)
        ) {
            Row() {
                Column() {
                    Text(
                        text = movie.ruName + "",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(top = 5.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Row() {
                        Text(
                            text = movie.altName + "",
                            color = Color.White,
                            fontSize = 13.sp
                        )
                        Text(
                            text = ", " + movie.year,
                            color = Color.White,
                            fontSize = 13.sp
                        )
                    }
                }
                Text(
                    text = movie.ratingKP.toString(),
                    color = Color.Green,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp).fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}