package com.adityadavin.sample.data.movie.remote

import com.adityadavin.sample.data.lib.ApiResponse
import com.adityadavin.sample.data.movie.model.MovieItem
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {

    @GET("discover/movie")
    fun getMovies(): Single<Response<ApiResponse<List<MovieItem>>>>
}