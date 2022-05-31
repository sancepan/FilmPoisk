package com.example.tututest

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tututest.data.MovieApiService
import com.example.tututest.models.movie.*
import com.example.tututest.network.RetrofitBuilder
import kotlinx.coroutines.launch

class MovieProfileViewModel : ViewModel() {
    var isLoading = mutableStateOf(false)
    var movieProfileResponse: MovieProfile by mutableStateOf(MovieProfile("123",
        listOf(Country("Страна")),
        "Описание",
        listOf(Genre("Жанр")),
        "Название",
        listOf(Person("", "", "", 0, "", "")),
        Poster("1", "123", "123"),
        Rating("1", 1, 8, 8.0, 8.0, 8),
        listOf(SeasonsInfo(1, 1)),
        Votes("", 8, 8, 8, 8, 8),
        2022
    ))
    var errorMessage: String by mutableStateOf("")
    fun getMovieProfile(id: Int) {
        viewModelScope.launch {
            val apiService = RetrofitBuilder.apiService
            try {
                val movieProfile = apiService.getMovieProfile(id)
                isLoading.value = true
                movieProfileResponse = movieProfile
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.e(TAG, "321")
            }
        }
    }
}