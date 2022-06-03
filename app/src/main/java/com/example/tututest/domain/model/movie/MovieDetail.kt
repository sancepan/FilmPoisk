package com.example.tututest.domain.model.movie

data class MovieDetail(
    val poster: String,
    val ruName: String,
    val altName: String,
    val year: Int,
    val ratingKP: Double,
    val votesKP: Int,
    val ratingIMDb: Double,
    val votesIMDb: Int,
    val countries: List<String>,
    val genres: List<String>,
    val description: String,
    val seasons: Int,
    val episodes: Int,
    val persons: List<Person>
)
