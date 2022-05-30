package com.example.tututest.data

import com.example.tututest.models.movie.MovieProfile
import com.example.tututest.models.movieList.MovieModel

interface MovieRepository {
    suspend fun getMovies(page: Int): MovieModel
    suspend fun getMovieProfile(id: Int): MovieProfile
}