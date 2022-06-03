package com.example.tututest.presentation.movie_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.example.tututest.data.dto.movieList.MovieDto
import com.example.tututest.data.paging.MovieSource
import com.example.tututest.domain.model.movieList.Movie
import com.example.tututest.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    fun getMovies(): Flow<PagingData<MovieDto>> {
        return Pager(PagingConfig(pageSize = 10)) {
            MovieSource(movieRepository)
        }.flow
    }
}