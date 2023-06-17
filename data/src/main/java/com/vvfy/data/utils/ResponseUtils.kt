package com.vvfy.data.utils

import retrofit2.Response
import java.net.UnknownHostException

internal inline fun <reified T: Any> Response<T>.response(): com.vvfy.domain.repository.Response<T> {
    val responseBody = body()
    return if (isSuccessful && responseBody != null) {
        com.vvfy.domain.repository.Response.success(responseBody)
    } else {
        com.vvfy.domain.repository.Response.error(
            Throwable(message())
        )
    }
}

fun handleNetworkException(throwable: Throwable): Throwable {
    return if (throwable is UnknownHostException) {
        Throwable("Unable to connect. Please check your internet connection.")
    } else {
        throwable
    }
}
