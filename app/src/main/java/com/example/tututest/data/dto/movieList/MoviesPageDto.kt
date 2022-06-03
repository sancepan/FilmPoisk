package com.example.tututest.data.dto.movieList

import com.example.tututest.domain.model.movieList.MoviesPage
import java.io.Serializable

data class MoviesPageDto(
    val docs: List<MovieDto>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
) : Serializable

fun MoviesPageDto.toMoviesPage(): MoviesPage{
    return MoviesPage(
        pageNum = page,
        movies = docs.map { it.toMovie() }
    )
}