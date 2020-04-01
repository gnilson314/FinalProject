package com.example.finalproject

import com.google.gson.annotations.SerializedName

data class GetFilm (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Film>,
    @SerializedName("pages") val pages: Int
)