package com.example.finalproject

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object Films {
    private val api_result: get_API_result;

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api_result = retrofit.create(get_API_result::class.java)
    }

    fun getPopularFilms(page: Int = 1, onSuccess: (movies: List<Film>) -> Unit,
                        onError: () -> Unit) {
        api_result.getPopularFilms(page = page)
            .enqueue(object : Callback<GetFilm> {
                override fun onResponse(
                    call: Call<GetFilm>,
                    response: Response<GetFilm>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    }else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetFilm>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}