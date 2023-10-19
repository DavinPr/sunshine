package com.adityadavin.sunshine.utils.rx.transformer

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer

class SingleSchedulerTransformer<T>(private val subscriber: Scheduler, private val observer: Scheduler) : SingleTransformer<T, T> {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.subscribeOn(subscriber).observeOn(observer)
    }
}