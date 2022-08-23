package com.au.cba.exercise.base


sealed class Resource<T:Any>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T : Any>(data: T) : Resource<T>(data)
    class Loading<T : Any>(data: T? = null) : Resource<T>(data)
    class Error<T : Any>(message: String, data: T? = null) : Resource<T>(data, message)
}
