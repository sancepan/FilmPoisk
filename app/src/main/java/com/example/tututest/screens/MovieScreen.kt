package com.example.tututest

import android.app.Activity
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.tututest.models.movie.Country
import com.example.tututest.models.movie.Genre
import com.example.tututest.models.movie.MovieProfile
import com.example.tututest.ui.theme.BackgroundColor
import com.example.tututest.ui.theme.ItemColor
import com.example.tututest.ui.theme.ShimmerColorShades
import java.text.DecimalFormat

@Composable
fun MovieScreen(movie: MovieProfile) {
    //Header()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(BackgroundColor),
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
                    .background(ItemColor)
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
                    .padding(top = 25.dp, bottom = 5.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movie.rating.kp.toString(),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text(
                    text = movie.alternativeName,
                    fontSize = 15.sp,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, start = 50.dp, end = 50.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text =
                            movie.year.toString() + ", " +
                            movie.countries.map (Country::name).joinToString(", ") +
                            ", " +
                            movie.genres.map (Genre::name).joinToString(", "),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White.copy(alpha = 0.5f),
                )
            }

            Text(
                text = movie.description,
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                    /*.background(BackgroundColor)
                    .clip(
                        RoundedCornerShape(10.dp)
                    ),*/
                style = TextStyle(
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Justify
                )
            )
            Text(
                text = "Сезоны и серии",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 25.dp, bottom = 7.dp, start = 20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
            )
            Row() {

                // Подсчет количества серий и эпизодов
                var seazons = 0
                var episodes = 0
                for (item in movie.seasonsInfo) {
                    seazons = item.number
                    episodes += item.episodesCount
                }

                // Окончание у сезонов
                var seazonEnd = ""
                if(seazons == 11 || seazons == 12 || seazons == 13 || seazons == 14){
                    seazonEnd = "ов"
                } else if (seazons%10 == 1){
                    seazonEnd = ""
                } else if(seazons%10 == 2 || seazons%10 == 3 || seazons%10 == 4){
                    seazonEnd = "а"
                } else if(seazons%10 == 5 || seazons%10 == 6 || seazons%10 == 7 || seazons%10 == 8 || seazons%10 == 9){
                    seazonEnd = "ов"
                }

                // Окончание у количества эпизодов
                var episodeEnd = ""
                if(episodes == 11 || episodes == 12 || episodes == 13 || episodes == 14){
                    episodeEnd = "й"
                } else if(episodes%10 == 1){
                    episodeEnd = "я"
                } else if(episodes%10 == 2 || episodes%10 == 3 || episodes%10 == 4){
                    episodeEnd = "и"
                }else if(episodes%10 == 5 || episodes%10 == 6 || episodes%10 == 7 || episodes%10 == 8 || episodes%10 == 9){
                    episodeEnd = "й"
                }

                Text(
                    text = "$seazons сезон$seazonEnd, ",
                    fontSize = 15.sp,
                    color = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier
                        .padding(bottom = 15.dp, start = 20.dp),
                )
                Text(
                    text = "$episodes сери$episodeEnd",
                    fontSize = 15.sp,
                    color = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier
                        .padding(bottom = 15.dp),
                )

            }
            Text(
                text = "Рейтинг кинопоиска",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 25.dp, start = 20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ItemColor)
                    .padding(vertical = 30.dp, horizontal = 20.dp),
            ) {
                var votes = DecimalFormat("###,###").format(movie.votes.kp).replace(',', ' ')
                Text(
                    text = movie.rating.kp.toString(),
                    fontSize = 51.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "$votes оценок",
                    fontSize = 15.sp,
                    color = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            }
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                // Вывод больших чисел с разделенными по три разрадами
                var votes = DecimalFormat("###,###").format(movie.votes.imdb).replace(',', ' ')
                RatingItem(rating = movie.rating.imdb, name = "Рейтинг IMDb", votes = votes)
                RatingItem(rating = movie.rating.imdb, name = "Рейтинг IMDb", votes = votes)
                RatingItem(rating = movie.rating.imdb, name = "Рейтинг IMDb", votes = votes)
            }

            Text(
                text = "Актеры",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 25.dp, bottom = 7.dp, start = 20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
            )

            // Получаем список актеров
            var list = movie.persons.filter { it.enProfession == "actor" }

            LazyHorizontalGrid(rows = GridCells.Fixed(4),
                modifier = Modifier
                    .height(300.dp),
                content = {
                items(list.size) { index ->
                    PersonItem(person = list[index])
                }
            }
            )

        }
    }

    ScrollAwareTopAppBar(scrollState.value, movie.name)

}

@Composable
fun ScrollAwareTopAppBar(
    scroll: Int,
    name: String,
) {

    val activity = (LocalContext.current as? Activity)

    val statusBarColor = if (scroll > 1100) {
        Color.Black
    } else {
        Color.Transparent
    }

    val text = if (scroll > 1100) {
        name
    } else {
        ""
    }

    TopAppBar(
        backgroundColor = statusBarColor,
        elevation = 0.dp,
    ) {
        IconButton(onClick = {
        //startActivity(Intent(mContext, MainActivity::class.java))
            activity?.finish()
        }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Меню", tint = Color.White)
        }
        
        Text(
            text = text,
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

    }
}








