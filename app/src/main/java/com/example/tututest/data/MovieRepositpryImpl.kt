package com.example.tututest.data

import com.example.tututest.models.MovieModel

class MovieRepositpryImpl(private val apiService: MovieApiService): MovieRepository {
    override suspend fun getMovies(page: Int): MovieModel {
        return apiService.getMovies(page)
    }
}