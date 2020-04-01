package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var bestMovies: RecyclerView
    private lateinit var bestMoviesAdapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bestMovies = findViewById(R.id.popular_movies)
        bestMovies.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        bestMoviesAdapter = FilmAdapter(listOf())
        bestMovies.adapter = bestMoviesAdapter

        Films.getPopularFilms(
                onSuccess = ::onFilmsGotten,
                onError = ::onError
        )
    }
    private fun onFilmsGotten(movies: List<Film>) {
        Log.d("main", "Movies: $movies")
        bestMoviesAdapter.updateMovies(movies)
    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }
}
