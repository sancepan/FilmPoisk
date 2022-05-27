package com.example.tututest.data

import com.example.tututest.models.MovieModel

interface MovieRepository {
    suspend fun getMovies(page: Int): MovieModel
}