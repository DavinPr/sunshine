package com.adityadavin.sunshine.utils.rx.operators

import com.adityadavin.sunshine.utils.exceptions.ApiException
import io.reactivex.SingleObserver
import io.reactivex.SingleOperator
import io.reactivex.disposables.Disposable
import retrofit2.Response

class SingleApiOperatorHandler<T> : SingleOperator<T, Response<T>> {

    override fun apply(observer: SingleObserver<in T>): SingleObserver<in Response<T>> {
        return object : SingleObserver<Response<T>> {
            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
            }

            override fun onSuccess(response: Response<T>) {
                when {
                    !response.isSuccessful -> observer.onError(UnsuccesfullResponseHandler.getApiError(response))
                    response.code() == 204 -> {
                        observer.onError(ApiException(ApiError("No Content", "Data Empty", 204), response))
                    }
                    else -> {
                        response.body()?.let { observer.onSuccess(it) }
                    }
                }
            }

            override fun onError(e: Throwable) {
                observer.onError(e)
            }
        }
    }
}