package com.adityadavin.sunshine.utils.rx.operators

import com.adityadavin.sunshine.utils.exceptions.ApiException
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

object UnsuccesfullResponseHandler {

    private const val HTTP_NOT_ACCEPTABLE: Int = 406

    private const val errorNoAcceptable = "Not Acceptable"
    private const val errorMessageInvalidResponse = "Invalid Response"

    private val gson = Gson()

    private fun isValidJsonArray(errorResponse: String?): Boolean {
        if (errorResponse == null) return false
        return try {
            JSONArray(errorResponse)
            true
        } catch (e: JSONException) {
            e.printStackTrace()
            false
        }
    }

    private fun isValidJsonObject(errorResponse: String?): Boolean {
        if (errorResponse == null) return false
        return try {
            JSONObject(errorResponse)
            true
        } catch (e: JSONException) {
            e.printStackTrace()
            false
        }
    }

    fun <T> getApiError(response: Response<T>): ApiException {
        val apiError = ApiError(errorNoAcceptable, errorMessageInvalidResponse, HTTP_NOT_ACCEPTABLE)
        response.errorBody().let { body ->
            val errorResponse = body?.string()

            if (!isValidJsonArray(errorResponse) && !isValidJsonObject(errorResponse)) return ApiException(apiError, response)

            return try {
                val envelope = gson.fromJson(errorResponse, ApiError::class.java)
                ApiException(envelope, response)
            } catch (e: IOException) {
                ApiException(apiError, response)
            }
        }
    }
}