package com.adityadavin.sunshine.utils.rx.operators

data class ApiError(
    val errorCode: String,
    val message: String,
    val statusCode: Int
)
