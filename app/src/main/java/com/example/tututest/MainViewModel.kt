package com.example.tututest

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tututest.data.MovieRepository
import com.example.tututest.models.movieList.Doc
import com.example.tututest.network.MovieSource
import kotlinx.coroutines.flow.Flow

class MainViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getPhotoPagination(): Flow<PagingData<Doc>> {
        return Pager(PagingConfig(pageSize = 10)) {
            MovieSource(movieRepository)
        }.flow
    }

}