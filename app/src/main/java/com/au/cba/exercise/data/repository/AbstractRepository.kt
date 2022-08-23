package com.au.cba.exercise.data.repository

//Act as an parent repository
interface AbstractRepository<T> {
    suspend fun getAll(): T
}