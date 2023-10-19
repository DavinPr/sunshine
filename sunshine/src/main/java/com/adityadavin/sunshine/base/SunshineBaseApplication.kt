package com.adityadavin.sunshine.base

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class SunshineBaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@SunshineBaseApplication)
            modules(listModules())
        }
    }

    abstract fun listModules() : List<Module>
}