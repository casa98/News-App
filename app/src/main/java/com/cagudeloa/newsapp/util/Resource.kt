package com.cagudeloa.newsapp.util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    // Only these classes are allowed to inherit from this Resource class (sealed magic):
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}