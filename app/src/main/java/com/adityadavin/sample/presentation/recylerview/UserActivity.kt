package com.adityadavin.sample.presentation.recylerview

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.adityadavin.sample.R
import com.adityadavin.sample.databinding.ActivityUserBinding
import com.adityadavin.sample.presentation.recylerview.adapter.UserAdapter
import com.adityadavin.sample.presentation.recylerview.detail.UserDetailActivity
import com.adityadavin.sample.presentation.recylerview.model.User
import com.adityadavin.sunshine.presentation.activity.BaseActivity
import com.adityadavin.sunshine.utils.recyclerview.decoration.LinearLayoutItemDecoration

class UserActivity : BaseActivity<ActivityUserBinding>() {

    override fun getViewBindingInflater(): ActivityUserBinding = ActivityUserBinding.inflate(layoutInflater)

    companion object {

        fun start(context: Context) {
            Intent(context, UserActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

    private val userAdapter: UserAdapter by lazy {
        UserAdapter(this, mutableListOf()) {
            UserDetailActivity.start(this, it)
        }
    }

    override fun initIntent() {
    }

    override fun initUI() {
        with(binding) {
            setupToolbar(toolbar.generalToolbar, getString(R.string.label_user), true)
            rvUser.apply {
                layoutManager = LinearLayoutManager(this@UserActivity)
                addItemDecoration(LinearLayoutItemDecoration(spacing = 8, edgeSpacing = 16))
                adapter = userAdapter
            }
        }
    }

    override fun initProcess() {
        val userList: List<User> = listOf(
            User(0, "https://randomuser.me/api/portraits/med/men/0.jpg", "Monkey D. Luffy"),
            User(1, "https://randomuser.me/api/portraits/med/men/1.jpg", "Roronoa Zoro"),
            User(2, "https://randomuser.me/api/portraits/med/men/2.jpg", "Vinsmoke Sanji"),
            User(3, "https://randomuser.me/api/portraits/med/men/3.jpg", "Jinbe"),
            User(4, "https://randomuser.me/api/portraits/med/men/4.jpg", "Usopp"),
            User(5, "https://randomuser.me/api/portraits/med/men/5.jpg", "Franky"),
            User(6, "https://randomuser.me/api/portraits/med/men/6.jpg", "Brook"),
            User(7, "https://randomuser.me/api/portraits/med/men/7.jpg", "Chopper"),
        )
        userAdapter.addOrUpdate(userList)
    }

    override fun initAction() {
        with(binding) {
            toolbar.generalToolbar.setNavigationOnClickListener {
                finish()
            }
        }
    }

    override fun initObserver() {
    }
}