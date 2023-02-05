package com.example.movieapptinkoff.data.retrofit.api

import com.example.movieapptinkoff.models.Film
import com.example.movieapptinkoff.models.MoviesModel
import com.example.movieapptinkoff.models.SingleFilm
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("X-API-KEY: 0ca27342-3d7a-45e9-9982-95d482cda716")
    @GET(" /api/v2.2/films/top?type=TOP_100_POPULAR_FILMS&page=1")
    suspend fun getPopularMovie(): Response<MoviesModel>

    @Headers("X-API-KEY: 0ca27342-3d7a-45e9-9982-95d482cda716")
    @GET(" /api/v2.2/films/4370148")
    suspend fun getSingleMovie(): Response<SingleFilm>

}