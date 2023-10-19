package com.adityadavin.sample.di

import com.adityadavin.sample.utils.constant.AppConstants
import com.adityadavin.sunshine.data.SharedPrefManager
import com.adityadavin.sunshine.data.SharedPrefManagerImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val PREFERENCE_NAME = "user_preference"

val preferenceModule = module {

    single(named(PREFERENCE_NAME)) { AppConstants.PREF_NAME }

    single<SharedPrefManager> { SharedPrefManagerImpl(get(), get(named(PREFERENCE_NAME)), get()) }

}
