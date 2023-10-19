package com.adityadavin.sample.data.lib

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class ParameterInterceptor(private val params: HashMap<String, String>) : Interceptor {

    override fun intercept(chain: Chain): Response {
        val builder = chain.request().newBuilder()
        val request = builder.url(mapParamsToHttpUrl(chain)).build()
        return chain.proceed(request)
    }

    private fun mapParamsToHttpUrl(chain: Chain): HttpUrl {
        val httpUrlBuilder = chain.request().url.newBuilder()
        return httpUrlBuilder.apply {
            params.forEach { param ->
                addQueryParameter(param.key, param.value)
            }
        }.build()
    }
}