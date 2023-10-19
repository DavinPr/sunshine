package com.adityadavin.sunshine.data

sealed class Result<out T> {
    companion object {

        fun default(): Result<Nothing> = Default
        fun loading(): Result<Nothing> = Loading
        fun empty(): Result<Nothing> = Empty
        fun <T> success(data: T): Result<T> = Success(data)
        fun fail(message: String?): Result<Nothing> = Failure(message, null)
        fun fail(message: String?, throwable: Throwable): Result<Nothing> = Failure(message, throwable)
    }

    object Default : Result<Nothing>()
    object Loading : Result<Nothing>()
    object Empty : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val message: String? = "There is no message on this error", val throwable: Throwable?) : Result<Nothing>()
}
