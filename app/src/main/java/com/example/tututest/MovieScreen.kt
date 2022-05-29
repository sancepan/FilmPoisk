package com.example.tututest

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.max
import kotlin.math.min
import coil.compose.rememberImagePainter
import com.example.tututest.models.Doc
import com.example.tututest.ui.theme.BackgroundColor

@Composable
fun MovieScreen(movie: Doc) {
    //Header()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        val height = 400.dp
        val width = 210

        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    //alpha = min(1f, 1 - (scrollState.value / 600f))
                    translationY = scrollState.value * 0.78f
                }
            ,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(
                    data = movie.poster.url
                ),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .background(Color.Green)
                    .blur(radius = 16.dp)
            )
            Image(
                painter = rememberImagePainter(
                    data = movie.poster.url
                ),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    //.fillMaxWidth()
                    .padding(top = 70.dp)
                    .clip(RoundedCornerShape(10.dp))
                    //.align(Alignment.CenterHorizontally)
                    .size(width = width.dp, height = 320.dp)
                    //.height(height)
            )
        }
        Column(modifier = Modifier
            .offset(y = (-15).dp)
            .clip(RoundedCornerShape(15.dp))
            .background(BackgroundColor)){
            Text(
                text = movie.name,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 25.dp, bottom = 15.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                )
            Text(
                text = movie.rating.kp.toString(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Text(
                text = movie.description,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(10.dp),
                    /*.background(BackgroundColor)
                    .clip(
                        RoundedCornerShape(10.dp)
                    ),*/
                style = TextStyle(
                    lineHeight = 135.sp,
                    textAlign = TextAlign.Justify
                )
            )
        }
    }
}



