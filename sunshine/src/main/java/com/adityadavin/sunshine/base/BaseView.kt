package com.adityadavin.sunshine.base

import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

interface BaseView {
    fun setupToolbar(toolbar: Toolbar?, title: String? = null, isNextLayout : Boolean = false)

    fun setFragment(@IdRes containerId: Int, fragment: Fragment, addToBackStack: Boolean = false)

    fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, addToBackStack: Boolean = false)
}