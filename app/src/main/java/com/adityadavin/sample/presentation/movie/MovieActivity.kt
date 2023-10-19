package com.adityadavin.sample.presentation.movie

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.adityadavin.sample.databinding.ActivityMovieBinding
import com.adityadavin.sample.presentation.movie.adapter.MovieAdapter
import com.adityadavin.sunshine.data.Result
import com.adityadavin.sunshine.presentation.activity.BaseActivity
import com.adityadavin.sunshine.utils.ext.showToast
import com.adityadavin.sunshine.utils.recyclerview.decoration.LinearLayoutItemDecoration
import com.kennyc.view.MultiStateView.ViewState.CONTENT
import com.kennyc.view.MultiStateView.ViewState.EMPTY
import com.kennyc.view.MultiStateView.ViewState.ERROR
import com.kennyc.view.MultiStateView.ViewState.LOADING
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieActivity : BaseActivity<ActivityMovieBinding>() {

    override fun getViewBindingInflater(): ActivityMovieBinding = ActivityMovieBinding.inflate(layoutInflater)

    companion object {

        fun start(context: Context) {
            Intent(context, MovieActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter(this, mutableListOf()) {
            showToast(it.title)
        }
    }

    private val movieViewModel: MovieViewModel by viewModel()

    override fun initIntent() {
    }

    override fun initUI() {
        with(binding) {
            rvMovie.apply {
                layoutManager = LinearLayoutManager(this@MovieActivity)
                adapter = movieAdapter
                addItemDecoration(LinearLayoutItemDecoration(16))
            }
        }
    }

    override fun initProcess() {
        movieViewModel.getMoviesCall()
    }

    override fun initAction() {
    }

    override fun initObserver() {
        movieViewModel.getMovies.observe(this) { result ->
            with(binding) {
                when (result) {
                    is Result.Default -> {}
                    is Result.Loading -> msvMovie.viewState = LOADING
                    is Result.Empty -> msvMovie.viewState = EMPTY
                    is Result.Success -> {
                        msvMovie.viewState = CONTENT
                        movieAdapter.addOrUpdate(result.data)
                    }
                    is Result.Failure -> {
                        msvMovie.viewState = ERROR
                    }
                }
            }
        }
    }
}