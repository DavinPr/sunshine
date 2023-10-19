package com.adityadavin.sample.data.movie.remote

import com.adityadavin.sample.data.lib.ApiResponse
import com.adityadavin.sample.data.movie.model.MovieItem
import com.adityadavin.sunshine.data.BaseApi
import io.reactivex.Single
import retrofit2.Response

class MovieApi(private val apiClient: MovieApiClient) : BaseApi, MovieApiClient {

    override fun getMovies(): Single<Response<ApiResponse<List<MovieItem>>>> = apiClient.getMovies()
}