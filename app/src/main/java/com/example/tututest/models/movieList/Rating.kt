package com.example.tututest.models.movieList

import java.io.Serializable

data class Rating(
    val _id: String,
    val await: Double,
    val filmCritics: Int,
    val imdb: Double,
    val kp: Double,
    val russianFilmCritics: Double
) : Serializable