package com.example.tututest.presentation.movie_detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.tututest.presentation.movie_detail.components.CustomTopAppBar
import com.example.tututest.presentation.movie_detail.components.PersonItem
import com.example.tututest.presentation.movie_detail.components.RatingItem
import com.example.tututest.presentation.movie_detail.components.ShimmerAnimation
import com.example.tututest.ui.theme.BackgroundColor
import com.example.tututest.ui.theme.ItemColor
import java.text.DecimalFormat

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    navController: NavController
) {

    val state = viewModel.state.value
    val scrollState = rememberScrollState()

    state.movie?.let { movie ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .background(BackgroundColor),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        translationY = scrollState.value * 0.78f
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = movie.poster
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
                        data = movie.poster
                    ),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 70.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .size(width = 210.dp, height = 320.dp)
                )
            }
            Column(
                modifier = Modifier
                    .offset(y = (-15).dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(BackgroundColor)
            ) {
                Text(
                    text = movie.ruName,
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
                        text = movie.ratingKP.toString(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                    Text(
                        text = movie.altName,
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
                        /*text =
                        movie.year.toString() + ", " +
                                movie.countries +
                                ", " +
                                movie.genres,*/
                        text = movie.year.toString() + ", " +
                                movie.countries.joinToString(", ") +
                                ", " +
                                movie.genres.joinToString(", "),
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

                    Text(
                        text = "1 сезон",
                        fontSize = 15.sp,
                        color = Color.White.copy(alpha = 0.5f),
                        modifier = Modifier
                            .padding(bottom = 15.dp, start = 20.dp),
                    )
                    Text(
                        text = "1 серия",
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
                    var votes = DecimalFormat("###,###").format(movie.votesKP).replace(',', ' ')
                    Text(
                        text = movie.ratingKP.toString(),
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
                    var votes = DecimalFormat("###,###").format(movie.votesIMDb).replace(',', ' ')
                    RatingItem(rating = movie.ratingIMDb, name = "Рейтинг IMDb", votes = votes)
                    RatingItem(rating = movie.ratingIMDb, name = "Рейтинг IMDb", votes = votes)
                    RatingItem(rating = movie.ratingIMDb, name = "Рейтинг IMDb", votes = votes)
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
                var list = movie.persons.filter { it.profession == "actor" }

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

        CustomTopAppBar(scrollState.value, movie.ruName, navController = navController)

    }
    if(state.error.isNotBlank()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Подключитесь к интернету",
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text =  "Проверьте подулючение к сети",
                color = Color.White.copy(alpha = 0.7f),
                fontSize =16.sp,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 20.dp)
            )
            CircularProgressIndicator(
                color = Color.White.copy(alpha = 0.5f)
            )
        }
    }
    if(state.isLoading) {
        ShimmerAnimation()
    }
}








