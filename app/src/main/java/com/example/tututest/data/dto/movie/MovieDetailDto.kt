package com.example.tututest.data.dto.movie

import com.example.tututest.domain.model.movie.MovieDetail

data class MovieDetailDto(
    //val ageRating: Int,
    val alternativeName: String,
    //val collections: List<Any>,
    val countries: List<Country>,
    //val createDate: String,*/
    val description: String,
    /*val distributors: Distributors,
    val enName: Any,
    val externalId: ExternalId,
    val facts: List<Fact>,
    val fees: Fees,*/
    val genres: List<Genre>,
    /*val id: Int,
    val images: Images,
    val lists: List<Any>,
    val movieLength: Int,*/
    val name: String,
    //val names: List<Name>,
    val persons: List<PersonDto>,
    val poster: Poster,
    /*val premiere: Premiere,
    val productionCompanies: List<Any>,*/
    val rating: Rating,
    //val ratingMpaa: Any,
    val seasonsInfo: List<SeasonsInfo>,
    /*val sequelsAndPrequels: List<SequelsAndPrequel>,
    val shortDescription: Any,
    val similarMovies: List<SimilarMovy>,
    val slogan: String,
    val spokenLanguages: List<Any>,
    val technology: Technology,
    val ticketsOnSale: Boolean,
    val type: String,
    val typeNumber: Int,
    val updateDates: List<String>,
    val updatedAt: String,
    val videos: Videos,*/
    val votes: Votes,
    val year: Int
)

fun MovieDetailDto.toMovieDetail(): MovieDetail{
    return MovieDetail(
        poster = poster.url,
        ruName = name,
        altName = alternativeName,
        year = year,
        ratingKP = rating.kp,
        votesKP = votes.kp,
        ratingIMDb = rating.imdb,
        votesIMDb = votes.imdb,
        countries = countries.map { it.name },
        genres = genres.map { it.name },
        description = description,
        seasons = 4,
        episodes = 4,
        persons = persons.map { it.toPerson() }
    )
}