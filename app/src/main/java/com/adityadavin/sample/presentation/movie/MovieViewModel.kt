package com.adityadavin.sample.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adityadavin.sample.domain.movie.MovieUseCase
import com.adityadavin.sample.domain.movie.model.Movie
import com.adityadavin.sunshine.data.Result
import com.adityadavin.sunshine.presentation.viewmodel.BaseViewModel
import com.adityadavin.sunshine.utils.ext.addTo
import com.adityadavin.sunshine.utils.rx.apihandler.errorHandler
import com.adityadavin.sunshine.utils.rx.transformer.singleScheduler
import io.reactivex.disposables.CompositeDisposable

class MovieViewModel(private val movieUseCase: MovieUseCase, private val disposable: CompositeDisposable) : BaseViewModel(disposable) {

    private val _getMovies = MutableLiveData<Result<List<Movie>>>()
    val getMovies: LiveData<Result<List<Movie>>> get() = _getMovies

    init {
        _getMovies.value = Result.default()
    }

    fun getMoviesCall() {
        _getMovies.value = Result.loading()

        movieUseCase.getMovies()
            .compose(singleScheduler())
            .subscribe({
                _getMovies.value = Result.success(it)
            }, {
                errorHandler(it, _getMovies)
            }).addTo(disposable)
    }
}