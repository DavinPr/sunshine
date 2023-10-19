package com.adityadavin.sunshine.utils.exceptions

import retrofit2.Response

open class ResponseException(open val response: Response<*>) : RuntimeException()