package com.example.tututest.presentation.movie_detail

import com.example.tututest.domain.model.movie.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)
