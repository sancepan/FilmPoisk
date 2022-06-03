package com.example.tututest.domain.use_case

import com.example.tututest.common.Resource
import com.example.tututest.data.dto.movieList.toMoviesPage
import com.example.tututest.domain.model.movieList.MoviesPage
import com.example.tututest.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
    ) {
    operator fun invoke(page: Int): Flow<Resource<MoviesPage>> = flow {
        try {
            emit(Resource.Loading<MoviesPage>())
            val movies = repository.getMovies(page).toMoviesPage()
            emit(Resource.Success<MoviesPage>(movies))
        } catch (e: HttpException){
            emit(Resource.Error<MoviesPage>(e.localizedMessage ?: "Произошла непредвиденная ошибка"))
        } catch(e: IOException){
            emit(Resource.Error<MoviesPage>("Не удалось связаться с сервером. Проверьте свое подключение к Интернету."))
        }
    }
}