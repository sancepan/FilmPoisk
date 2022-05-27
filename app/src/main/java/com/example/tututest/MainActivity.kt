package com.example.tututest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.tututest.data.MovieRepositpryImpl
import com.example.tututest.ui.theme.BackgroundColor

class MainActivity : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()

        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this,R.color.black)

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(BackgroundColor)
            ) {
                Header()
                MovieList(vm = mainViewModel)
            }
        }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(MovieRepositpryImpl(RetrofitBuilder.apiService),)
        )[MainViewModel::class.java]
    }

}

@Composable
fun MovieList(vm: MainViewModel) {
    val projects = vm.getPhotoPagination().collectAsLazyPagingItems()
    LazyColumn {
        itemsIndexed(projects) { index, item ->
            MovieItem(movie = item!!)
        }
        projects.apply {
            when {
                loadState.refresh is LoadState.Loading -> item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillParentMaxSize()
                    ) {
                        CircularProgressIndicator(
                            color = Color.White
                        )
                    }
                }
                loadState.append is LoadState.Loading -> item {
                    CircularProgressIndicator(
                        color = Color.Blue
                    )
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
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.size(15.dp)
                                .fillMaxSize()
                        )
                        Text(
                            text =  "Проверьте подулючение к сети",
                            color = Color.White,
                            modifier = Modifier.size(13.dp)
                                .padding(vertical = 3.dp)
                        )
                        CircularProgressIndicator(
                            color = Color.Blue
                        )
                    }
                }
                loadState.append is LoadState.Error -> item {
                    CircularProgressIndicator(
                        color = Color.White
                    )
                }
            }
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