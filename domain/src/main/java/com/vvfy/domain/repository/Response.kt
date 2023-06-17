package com.vvfy.domain.repository

sealed class Response<out T: Any> {

    data class Success<out T: Any>(val data: T) : Response<T>()
    data class Error(val cause: Throwable? = null) : Response<Nothing>()

    companion object {
        fun <T: Any> success(data: T) = Success(data)
        fun error(cause: Throwable? = null) = Error(cause)
    }

    inline fun onSuccess(block: (T) -> Unit): Response<T> {
        if (this is Success) {
            block(data)
        }
        return this
    }

    inline fun onError(block: (Throwable?) -> Unit): Response<T> {
        if (this is Error) {
            block(cause)
        }
        return this
    }
}