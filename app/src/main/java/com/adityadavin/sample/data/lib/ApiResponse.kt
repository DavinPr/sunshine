package com.adityadavin.sample.data.lib

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("results")
    val data: T
)
