package com.example.tututest.models.movieList

import java.io.Serializable

data class ExternalId(
    val _id: String,
    val imdb: Any
) : Serializable