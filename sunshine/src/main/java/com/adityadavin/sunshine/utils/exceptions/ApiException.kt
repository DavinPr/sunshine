package com.adityadavin.sunshine.utils.exceptions

import com.adityadavin.sunshine.utils.rx.operators.ApiError
import retrofit2.Response

class ApiException(val apiError: ApiError, override var response: Response<*>) : ResponseException(response) {

}