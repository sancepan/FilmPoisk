package com.example.tututest.network

import android.content.ContentValues.TAG
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tututest.data.MovieRepository
import com.example.tututest.models.movieList.Doc

class MovieSource(private val movieRepository: MovieRepository): PagingSource<Int, Doc>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Doc> {
        return try {
            val page = params.key ?: 1
            val movieResponse = movieRepository.getMovies(page)
            LoadResult.Page(
                data = movieResponse.docs,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (params.loadSize >= 10) {
                    Log.e(TAG, "1234 " + " " + params.loadSize)
                    Log.e(TAG, "12345  $page")
                    page.plus(1)
                } else {
                    null
                    Log.e(TAG, "123456  $page")
                    Log.e(TAG, "123" + movieResponse.docs.size + " " + params.loadSize)
                }
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