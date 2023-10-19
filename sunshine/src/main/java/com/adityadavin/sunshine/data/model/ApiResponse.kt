package com.adityadavin.sunshine.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("data")
    val data: T? = null
)