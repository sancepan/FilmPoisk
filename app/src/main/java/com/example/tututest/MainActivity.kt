package com.example.tututest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.tututest.models.MovieModel
import com.example.tututest.ui.theme.BackgroundColor

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this,R.color.black)

            Column(
                modifier = Modifier.fillMaxHeight().background(BackgroundColor)
            ) {
                Header()
                MovieList(movieList = mainViewModel.movieListResponse)
                mainViewModel.getMovieList()
            }
        }
    }
}

@Composable
fun MovieList(movieList: MovieModel) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
    ) {
        itemsIndexed(items = movieList.docs) { index, item ->
            MovieItem(movie = item)
        }
    }
}

@Composable
fun Header(){
    Text(
        text = "Фильмы",
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .padding(horizontal = 3.dp, vertical = 8.dp),
        color = Color.White,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,)
}