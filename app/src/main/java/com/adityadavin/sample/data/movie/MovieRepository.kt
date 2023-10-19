package com.adityadavin.sample.data.movie

import com.adityadavin.sample.data.movie.model.MovieItem
import com.adityadavin.sunshine.data.BaseRepository
import io.reactivex.Single

interface MovieRepository : BaseRepository {

    fun getMovies(): Single<List<MovieItem>>
}