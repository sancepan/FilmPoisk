package com.example.tututest.domain.repository

import com.example.tututest.data.dto.movie.MovieDetailDto
import com.example.tututest.data.dto.movieList.MoviesPageDto

interface MovieRepository {
    suspend fun getMovies(page: Int): MoviesPageDto
    suspend fun getMovieProfile(id: String): MovieDetailDto
}