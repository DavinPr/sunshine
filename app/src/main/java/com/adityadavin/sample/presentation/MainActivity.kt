package com.adityadavin.sample.presentation

import com.adityadavin.sample.R
import com.adityadavin.sample.databinding.ActivityMainBinding
import com.adityadavin.sample.presentation.movie.MovieActivity
import com.adityadavin.sample.presentation.recylerview.UserActivity
import com.adityadavin.sunshine.presentation.activity.BaseActivity
import com.adityadavin.sunshine.utils.ext.onClick

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBindingInflater(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initIntent() {
    }

    override fun initUI() {
        with(binding) {
            setupToolbar(toolbar.generalToolbar, getString(R.string.app_name), false)
        }
    }

    override fun initProcess() {
    }

    override fun initAction() {
        with(binding) {
            btnRecyclerView.onClick {
                UserActivity.start(this@MainActivity)
            }
            btnMovie.onClick {
                MovieActivity.start(this@MainActivity)
            }
        }
    }

    override fun initObserver() {
    }
}