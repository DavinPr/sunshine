package com.adityadavin.sample.di

import com.adityadavin.sample.data.AppDatabase
import org.koin.dsl.module

const val DATABASE_NAME = "favorite-database"
val dbModule = module {

    factory { AppDatabase.getAppDatabase(context = get(), databaseName = DATABASE_NAME) }
}