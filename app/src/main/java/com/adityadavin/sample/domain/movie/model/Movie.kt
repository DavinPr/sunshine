package com.adityadavin.sample.domain.movie.model

import com.adityadavin.sample.BuildConfig
import com.adityadavin.sample.data.movie.model.MovieItem

data class Movie(
    val overview: String? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val id: Int = 0,
)

fun MovieItem.mapToMovie(): Movie {
    return Movie(
        overview, title, BuildConfig.IMAGE_URL + posterPath, releaseDate, id
    )
}
