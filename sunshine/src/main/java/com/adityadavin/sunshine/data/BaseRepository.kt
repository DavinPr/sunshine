package com.adityadavin.sunshine.data

interface BaseRepository {

    val dbService: BaseLocalDb?
    val apiService: BaseApi?
}