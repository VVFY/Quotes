package com.vvfy.domain.model

data class NullableWrapper<T: Any?>(val value: T? = null)