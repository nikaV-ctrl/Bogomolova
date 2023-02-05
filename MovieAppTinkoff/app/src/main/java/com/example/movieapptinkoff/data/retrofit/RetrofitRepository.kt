package com.example.movieapptinkoff.data.retrofit

import com.example.movieapptinkoff.data.retrofit.api.RetrofitInstance
import com.example.movieapptinkoff.models.MoviesModel
import com.example.movieapptinkoff.models.SingleFilm
import retrofit2.Response

class RetrofitRepository {

    suspend fun getMovies(): Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovie()
    }
    suspend fun getOneMovie(): Response<SingleFilm>{
        return RetrofitInstance.api.getSingleMovie()
    }
}