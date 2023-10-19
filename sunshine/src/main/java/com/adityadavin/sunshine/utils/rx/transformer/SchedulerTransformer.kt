package com.adityadavin.sunshine.utils.rx.transformer

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> singleScheduler(
    subscribeScheduler: Scheduler = Schedulers.io(),
    observerScheduler: Scheduler = AndroidSchedulers.mainThread()
): SingleSchedulerTransformer<T> = SingleSchedulerTransformer(subscribeScheduler, observerScheduler)