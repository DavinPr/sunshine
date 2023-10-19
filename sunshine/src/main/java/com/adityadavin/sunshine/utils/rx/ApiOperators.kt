package com.adityadavin.sunshine.utils.rx

import com.adityadavin.sunshine.utils.rx.operators.SingleApiOperatorHandler

fun <T> singleApiHandler() = SingleApiOperatorHandler<T>()