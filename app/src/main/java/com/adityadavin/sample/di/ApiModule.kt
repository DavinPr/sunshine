package com.adityadavin.sample.di

import com.adityadavin.sample.BuildConfig
import com.adityadavin.sample.data.lib.HeaderInterceptor
import com.adityadavin.sample.data.lib.ParameterInterceptor
import com.adityadavin.sunshine.data.libs.OkHttpClientBuilder
import okhttp3.Interceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.collections.set

const val BASE_URL: String = "baseUrl"

val apiModule = module {

    single {
        return@single OkHttpClientBuilder.build(
            interceptors = arrayOf(getHeaderInterceptor(), getParameterInterceptor()),
            authenticator = null,
            showLog = BuildConfig.DEBUG,
        )
    }

    single(named(BASE_URL)) { BuildConfig.BASE_URL }

}

private fun getParameterInterceptor(): Interceptor {
    val params = HashMap<String, String>()
    //define default parameter here
    params["api_key"] = BuildConfig.API_KEY
    return ParameterInterceptor(params)
}

private fun getHeaderInterceptor(): Interceptor {
    val headers = HashMap<String, String>()
    //define default headers here
    headers["Content-Type"] = "application/json"

    return HeaderInterceptor(headers)
}