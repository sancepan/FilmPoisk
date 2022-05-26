package com.example.tututest

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tututest.models.MovieModel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var movieListResponse:MovieModel by mutableStateOf(MovieModel(listOf(), 0, 0, 0, 0))
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                Log.e(TAG, "1234")
                val movieList = apiService.getMovies()
                Log.e(TAG, "12345 $movieList")
                movieListResponse = movieList
            }
            catch (e: Exception) {
                Log.e(TAG, "12345 " + e.message.toString())
                errorMessage = e.message.toString()
            }
        }
    }
}