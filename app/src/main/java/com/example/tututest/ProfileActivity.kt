package com.example.tututest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.tututest.models.movieList.Doc

class ProfileActivity : ComponentActivity()  {

    private val movie: Doc by lazy {
        intent?.getSerializableExtra(MOVIE_ID) as Doc
    }

    private val movieProfileViewModel by viewModels<MovieProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.statusBarColor = ContextCompat.getColor(this,R.color.black)
        setContent {
            val id = movie.id
            MovieScreen(movieProfileViewModel.movieProfileResponse)
            movieProfileViewModel.getMovieProfile(id)
        }
    }

    companion object {
        private const val MOVIE_ID = "movie_id"
        fun newIntent(context: Context, movie: Doc) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(MOVIE_ID, movie)
            }
    }
}