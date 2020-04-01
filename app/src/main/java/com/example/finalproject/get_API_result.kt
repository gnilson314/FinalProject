package com.example.finalproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface get_API_result {
    @GET("movie/popular")

    fun getPopularFilms(
        @Query("api_key") apiKey: String = "eeb6c87d11f31e76ecc2b1b2f49d0df9",
        @Query("page") page: Int
    ): Call<GetFilm>
}