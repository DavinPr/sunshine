package com.adityadavin.sample.domain.movie

import com.adityadavin.sample.domain.movie.model.Movie
import io.reactivex.Single

interface MovieUseCase {

    fun getMovies(): Single<List<Movie>>
}