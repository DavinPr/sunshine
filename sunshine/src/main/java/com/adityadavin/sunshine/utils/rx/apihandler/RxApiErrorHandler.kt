package com.adityadavin.sunshine.utils.rx.apihandler

import androidx.lifecycle.MutableLiveData
import com.adityadavin.sunshine.data.Result
import com.adityadavin.sunshine.utils.exceptions.ApiException
import com.google.gson.JsonSyntaxException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.net.ssl.SSLHandshakeException
import javax.net.ssl.SSLPeerUnverifiedException

fun <T> errorHandler(throwable: Throwable, result: MutableLiveData<Result<T>>) {
    when (throwable) {
        is ApiException -> result.value = Result.fail(throwable.apiError.message, throwable)
        is SocketTimeoutException -> Result.fail("Connection Timeout", throwable)
        is SSLHandshakeException -> Result.fail("SSL Certificate not matched.", throwable)
        is SSLPeerUnverifiedException -> Result.fail("SSL Certificate not matched.", throwable)
        is IOException -> Result.fail("Connection IOException", throwable)
        is JsonSyntaxException -> Result.fail("JSON Exception", throwable)
        else -> Result.fail("An unknown error occurred", throwable)
    }
}