package com.adityadavin.sunshine.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.adityadavin.sunshine.base.BaseView
import com.adityadavin.sunshine.presentation.activity.BaseActivity

abstract class BaseFragment<VB : ViewBinding> : Fragment(), BaseView {

    private lateinit var baseActivity: BaseActivity<*>

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initViewBinding(inflater, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onViewReady()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as BaseActivity<*>
    }

    private fun onViewReady() {
        initIntent()
        initUI()
        initProcess()
        initAction()
        initObserver()
    }

    abstract fun getViewBindingInflater(layoutInflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): VB
    private fun initViewBinding(layoutInflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): View {
        binding = getViewBindingInflater(layoutInflater, container, attachToRoot)
        return binding.root
    }

    abstract fun initIntent()
    abstract fun initUI()
    abstract fun initProcess()
    abstract fun initAction()
    abstract fun initObserver()

    override fun setupToolbar(toolbar: Toolbar?, title: String?, isNextLayout: Boolean) {
        with(baseActivity) {
            toolbar?.let { setSupportActionBar(it) }
            supportActionBar?.let { actionBar ->
                title?.let { actionBar.title = it }
                actionBar.setDisplayHomeAsUpEnabled(isNextLayout)
            }
        }
    }

    override fun setFragment(@IdRes containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
        childFragmentManager
            .beginTransaction().apply {
                add(containerId, fragment, fragment.javaClass.name)
                if (addToBackStack) addToBackStack(null)
                commit()
            }
    }

    override fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
        childFragmentManager
            .beginTransaction().apply {
                replace(containerId, fragment, fragment.javaClass.name)
                if (addToBackStack) addToBackStack(null)
                commit()
            }
    }
}