package com.adityadavin.sample.di.movie

import com.adityadavin.sample.data.movie.MovieDataStore
import com.adityadavin.sample.data.movie.MovieRepository
import com.adityadavin.sample.data.movie.remote.MovieApi
import com.adityadavin.sample.data.movie.remote.MovieApiClient
import com.adityadavin.sample.di.BASE_URL
import com.adityadavin.sample.domain.movie.MovieInteractor
import com.adityadavin.sample.domain.movie.MovieUseCase
import com.adityadavin.sample.presentation.movie.MovieViewModel
import com.adityadavin.sunshine.data.libs.ApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val movieModule = module {
    single { ApiService.createRxService(MovieApiClient::class.java, get(), get(named(BASE_URL))) }
    single { MovieApi(get()) }
    single<MovieRepository> { MovieDataStore(get()) }
    single<MovieUseCase> { MovieInteractor(get()) }
    viewModel { MovieViewModel(get(), get()) }
}