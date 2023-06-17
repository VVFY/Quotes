package com.vvfy.data.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiInstance {
    val default: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}