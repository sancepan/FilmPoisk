package com.example.tututest

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tututest.data.MovieRepository
import com.example.tututest.models.Doc

class MovieSource(private val movieRepository: MovieRepository): PagingSource<Int, Doc>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Doc> {
        return try {
            val page = params.key ?: 1
            val movieResponse = movieRepository.getMovies(page)
            LoadResult.Page(
                data = movieResponse.docs,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (movieResponse.docs.size < 10) null else page.plus(1)
                //nextKey = page.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Doc>): Int? {
        TODO("Not yet implemented")
    }
}