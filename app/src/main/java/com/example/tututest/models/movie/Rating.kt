package com.example.tututest.models.movie

data class Rating(
    val _id: String,
    val await: Int,
    val filmCritics: Int,
    val imdb: Double,
    val kp: Double,
    val russianFilmCritics: Int
)