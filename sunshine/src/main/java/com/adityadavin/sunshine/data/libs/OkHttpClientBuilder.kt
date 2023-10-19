package com.adityadavin.sunshine.data.libs

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClientBuilder {

    fun build(interceptors: Array<Interceptor>, authenticator: Authenticator?, showLog: Boolean): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                interceptors.forEach { addInterceptor(it) }
                if (showLog) addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                authenticator?.let { authenticator(it) }
            }
            .build()
    }
}