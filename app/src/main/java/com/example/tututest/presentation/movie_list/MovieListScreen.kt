package com.example.tututest.presentation.movie_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.tututest.presentation.movie_list.components.MovieItem
import com.example.tututest.data.dto.movieList.toMovie
import com.example.tututest.presentation.Screen
import com.example.tututest.presentation.movie_list.components.Header
import com.example.tututest.ui.theme.BackgroundColor

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {

    val getMovies = viewModel.getMovies().collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(BackgroundColor)
    ) {
        Header(text = "FilmPoisk")
        LazyColumn {
            itemsIndexed(getMovies) { index, item ->
                MovieItem(
                    movie = item!!.toMovie(),
                    onItemClick = {
                        navController.navigate(Screen.MovieDetailScreen.route + "/${item.toMovie().id}")
                    }
                )
            }
            getMovies.apply {
                when {
                    loadState.refresh is LoadState.Loading -> item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillParentMaxSize()
                        ) {
                            CircularProgressIndicator(
                                color = Color.White.copy(alpha = 0.5f)
                            )
                        }
                    }
                    loadState.refresh is LoadState.Error -> item {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillParentMaxSize()
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
                }
            }
        }
    }
}