package com.adityadavin.sample.base

import com.adityadavin.sample.di.apiModule
import com.adityadavin.sample.di.dbModule
import com.adityadavin.sample.di.movie.movieModule
import com.adityadavin.sample.di.preferenceModule
import com.adityadavin.sample.di.rxModule
import com.adityadavin.sample.di.utilityModule
import com.adityadavin.sunshine.base.SunshineBaseApplication
import org.koin.core.module.Module

class SunshineSampleApplication : SunshineBaseApplication() {

    override fun listModules(): List<Module> {
        return listOf(
            apiModule,
            dbModule,
            preferenceModule,
            rxModule,
            utilityModule,
            movieModule
        )
    }
}