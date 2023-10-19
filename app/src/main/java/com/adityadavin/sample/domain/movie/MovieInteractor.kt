package com.adityadavin.sample.domain.movie

import com.adityadavin.sample.data.movie.MovieRepository
import com.adityadavin.sample.domain.movie.model.Movie
import com.adityadavin.sample.domain.movie.model.mapToMovie
import io.reactivex.Single

class MovieInteractor(private val repository: MovieRepository) : MovieUseCase {

    override fun getMovies(): Single<List<Movie>> = repository.getMovies().map { it.map { movieItem -> movieItem.mapToMovie() } }
}