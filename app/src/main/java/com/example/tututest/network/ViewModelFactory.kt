package com.example.tututest.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tututest.MainViewModel
import com.example.tututest.data.MovieRepository

class ViewModelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(movieRepository) as T
        } else{
            return MainViewModel(movieRepository) as T
        }
    }
}