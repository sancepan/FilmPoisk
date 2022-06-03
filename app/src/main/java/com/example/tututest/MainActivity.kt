package com.example.tututest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tututest.presentation.Screen
import com.example.tututest.presentation.movie_detail.MovieDetailScreen
import com.example.tututest.presentation.movie_list.MovieListScreen
import com.example.tututest.ui.theme.TuTuTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            this.window.statusBarColor = ContextCompat.getColor(this,R.color.black)

            TuTuTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MovieListScreen.route
                    ) {
                        composable(
                            route = Screen.MovieListScreen.route
                        ) {
                            MovieListScreen(navController)
                        }
                        composable(
                            route = Screen.MovieDetailScreen.route + "/{movie_id}"
                        ) {
                            navController.previousBackStackEntry?.arguments.let {
                                MovieDetailScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}