package com.example.tututest.data.dto.movie

import com.example.tututest.domain.model.movie.Person

data class PersonDto(
    val description: Any,
    val enName: String,
    val enProfession: String,
    val id: Int,
    val name: String,
    val photo: String
)

fun PersonDto.toPerson(): Person{
    return Person(
        photo = photo,
        ruName = name + "",
        altName = enName + "",
        profession = enProfession
    )
}