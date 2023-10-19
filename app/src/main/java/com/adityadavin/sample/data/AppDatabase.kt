package com.adityadavin.sample.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

// TODO: Uncomment this and add entities if you're gonna using Room
//@Database(entities = [], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context, databaseName: String): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, databaseName)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

// TODO: add Dao here

}
