package com.adityadavin.sunshine.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.adityadavin.sunshine.base.BaseView

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), BaseView {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initViewBinding())

        initIntent()
        initUI()
        initProcess()
        initAction()
        initObserver()
    }

    abstract fun getViewBindingInflater(): VB
    private fun initViewBinding(): View {
        binding = getViewBindingInflater()
        return binding.root
    }

    abstract fun initIntent()
    abstract fun initUI()
    abstract fun initProcess()
    abstract fun initAction()
    abstract fun initObserver()

    override fun setupToolbar(toolbar: Toolbar?, title: String?, isNextLayout: Boolean) {
        toolbar?.let { setSupportActionBar(it) }
        supportActionBar?.let { actionBar ->
            title?.let { actionBar.title = it }
            actionBar.setDisplayHomeAsUpEnabled(isNextLayout)
        }
    }

    override fun setFragment(@IdRes containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
        supportFragmentManager
            .beginTransaction().apply {
                add(containerId, fragment, fragment.javaClass.name)
                if (addToBackStack) addToBackStack(null)
                commit()
            }
    }

    override fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
        supportFragmentManager
            .beginTransaction().apply {
                replace(containerId, fragment, fragment.javaClass.name)
                if (addToBackStack) addToBackStack(null)
                commit()
            }
    }
}