package com.example.tututest.data

import com.example.tututest.models.movie.MovieProfile
import com.example.tututest.models.movieList.MovieModel

class MovieRepositpryImpl(private val apiService: MovieApiService): MovieRepository {
    override suspend fun getMovies(page: Int): MovieModel {
        return apiService.getMovies(page)
    }

    override suspend fun getMovieProfile(id: Int): MovieProfile {
        return apiService.getMovieProfile(id)
    }
}