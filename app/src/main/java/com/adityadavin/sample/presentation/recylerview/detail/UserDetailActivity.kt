package com.adityadavin.sample.presentation.recylerview.detail

import android.content.Context
import android.content.Intent
import com.adityadavin.sample.databinding.ActivityUserDetailBinding
import com.adityadavin.sample.presentation.recylerview.model.User
import com.adityadavin.sample.utils.constant.BundleKeys
import com.adityadavin.sunshine.presentation.activity.BaseActivity
import com.adityadavin.sunshine.utils.ext.setImageUrl

class UserDetailActivity : BaseActivity<ActivityUserDetailBinding>() {

    override fun getViewBindingInflater(): ActivityUserDetailBinding = ActivityUserDetailBinding.inflate(layoutInflater)

    companion object {

        fun start(context: Context, data: User) {
            Intent(context, UserDetailActivity::class.java).apply {
                putExtra(BundleKeys.USER_KEY, data)
                context.startActivity(this)
            }
        }
    }

    private var user: User? = null

    override fun initIntent() {
        user = intent.getParcelableExtra(BundleKeys.USER_KEY)
    }

    override fun initUI() {
        with(binding) {
            user?.let { user ->
                setupToolbar(toolbar.generalToolbar, user.id?.toString() ?: "User", true)
                tvName.text = user.name
                user.image?.let { imgAvatar.setImageUrl(this@UserDetailActivity, it) }
            }
        }
    }

    override fun initProcess() {
    }

    override fun initAction() {
        with(binding) {
            toolbar.generalToolbar.setNavigationOnClickListener { finish() }
        }
    }

    override fun initObserver() {
    }
}