package com.example.tututest.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tututest.data.dto.movieList.MovieDto
import com.example.tututest.domain.repository.MovieRepository

class MovieSource(private val movieRepository: MovieRepository): PagingSource<Int, MovieDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        return try {
            val page = params.key ?: 1
            val movieResponse = movieRepository.getMovies(page)
            LoadResult.Page(
                data = movieResponse.docs,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (params.loadSize >= 10) {
                    page.plus(1)
                } else {
                    null
                }
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        TODO("Not yet implemented")
    }
}