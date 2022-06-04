package com.example.tututest.data.dto.movieList

import com.example.tututest.domain.model.movieList.Movie
import java.io.Serializable

data class MovieDto(
    val alternativeName: String,
    val color: String,
    val description: String,
    val enName: Any,
    val externalId: ExternalId,
    val id: Int,
    val movieLength: Int,
    val name: String,
    val names: List<Name>,
    val poster: Poster,
    val rating: Rating,
    val shortDescription: Any,
    val type: String,
    val votes: Votes,
    val year: Int
) :Serializable

fun MovieDto.toMovie(): Movie{
    return Movie(
        id = id,
        poster = poster.url,
        ruName = name + "",
        altName = names[1].name + "",
        year = year,
        ratingKP = rating.kp
    )
}