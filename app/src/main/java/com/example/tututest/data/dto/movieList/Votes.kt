package com.example.tututest.data.dto.movieList

import java.io.Serializable

data class Votes(
    val _id: String,
    val await: Int,
    val filmCritics: Int,
    val imdb: Int,
    val kp: Int,
    val russianFilmCritics: Int
) : Serializable