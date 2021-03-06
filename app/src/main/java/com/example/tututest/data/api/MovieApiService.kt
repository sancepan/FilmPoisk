package com.example.tututest.data.api

import com.example.tututest.data.dto.movie.MovieDetailDto
import com.example.tututest.data.dto.movieList.MoviesPageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/movie?field=rating.kp&search=7-10&field=year&search=2017-2020&field=typeNumber&search=2&sortField=year&sortType=1&sortField=votes.imdb&sortType=-1&token=EBTAGQF-FHWMWVM-HHZ99RS-7NFD4ZP")
    suspend fun getMovies(
        @Query("page") pageNumber: Int,
        @Query("limit") limit: Int = 10
    ): MoviesPageDto

    @GET("/movie?token=EBTAGQF-FHWMWVM-HHZ99RS-7NFD4ZP&field=id")
    suspend fun getMovieDetail(
        @Query("search") id: String
    ): MovieDetailDto


}