package com.example.tututest.domain.use_case

import com.example.tututest.common.Resource
import com.example.tututest.data.dto.movie.toMovieDetail
import com.example.tututest.domain.model.movie.MovieDetail
import com.example.tututest.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
    ) {
    operator fun invoke(id: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading<MovieDetail>())
            val movies = repository.getMovieDetail(id).toMovieDetail()
            emit(Resource.Success<MovieDetail>(movies))
        } catch (e: HttpException){
            emit(Resource.Error<MovieDetail>(e.localizedMessage ?: "Произошла непредвиденная ошибка"))
        } catch(e: IOException){
            emit(Resource.Error<MovieDetail>("Не удалось связаться с сервером. Проверьте свое подключение к Интернету."))
        }
    }
}