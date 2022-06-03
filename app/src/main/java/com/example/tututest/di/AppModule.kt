package com.example.tututest.di

import com.example.tututest.common.Constants
import com.example.tututest.data.api.MovieApiService
import com.example.tututest.data.repository.MovieRepositoryImpl
import com.example.tututest.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMovieApi(): MovieApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: MovieApiService): MovieRepository {
        return MovieRepositoryImpl(api)
    }

}