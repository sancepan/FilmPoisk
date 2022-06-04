package com.example.tututest.data.repository

import com.example.tututest.data.api.MovieApiService
import com.example.tututest.data.dto.movie.MovieDetailDto
import com.example.tututest.data.dto.movieList.MoviesPageDto
import com.example.tututest.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService
    ): MovieRepository {

    override suspend fun getMovies(page: Int): MoviesPageDto {
        return apiService.getMovies(page)
    }

    override suspend fun getMovieDetail(id: String): MovieDetailDto {
        return apiService.getMovieDetail(id)
    }
}