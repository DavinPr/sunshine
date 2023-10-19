package com.adityadavin.sample.data.movie

import com.adityadavin.sample.data.movie.model.MovieItem
import com.adityadavin.sample.data.movie.remote.MovieApi
import com.adityadavin.sunshine.data.BaseLocalDb
import com.adityadavin.sunshine.utils.rx.singleApiHandler
import io.reactivex.Single

class MovieDataStore(apiClient: MovieApi) : MovieRepository {

    override fun getMovies(): Single<List<MovieItem>> {
        return apiService.getMovies()
            .lift(singleApiHandler())
            .map { it.data }
    }

    override val dbService: BaseLocalDb?
        get() = null
    override val apiService = apiClient
}