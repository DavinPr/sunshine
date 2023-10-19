package com.adityadavin.sample.data.lib

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor(private val headers: HashMap<String, String>) : Interceptor {

    override fun intercept(chain: Chain): Response {
        val request = mapHeadersToRequest(chain)
        return chain.proceed(request)
    }

    private fun mapHeadersToRequest(chain: Chain): Request {
        val requestBuilder = chain.request().newBuilder()
        return requestBuilder
            .apply {
                headers.forEach { header ->
                    addHeader(header.key, header.value)
                }
            }
            .build()
    }
}