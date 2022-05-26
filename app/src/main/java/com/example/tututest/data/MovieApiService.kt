package com.example.tututest

import com.example.tututest.models.MovieModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApiService {

    @GET("/movie?field=rating.kp&search=7-10&field=year&search=2017-2020&field=typeNumber&search=2&sortField=year&sortType=1&sortField=votes.imdb&sortType=-1&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06")
    suspend fun getMovies(): MovieModel

    companion object{

        val BASE_URL = "https://api.kinopoisk.dev"

        var movieApiService: MovieApiService? = null
        fun getInstance() : MovieApiService {
            if (movieApiService == null) {
                movieApiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(MovieApiService::class.java)
            }
            return movieApiService!!
        }
    }

}