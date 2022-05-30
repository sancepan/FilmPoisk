package com.example.tututest.models.movieList

import java.io.Serializable

data class Poster(
    val _id: String,
    val previewUrl: String,
    val url: String
) : Serializable