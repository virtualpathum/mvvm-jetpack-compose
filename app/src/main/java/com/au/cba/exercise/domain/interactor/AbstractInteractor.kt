package com.au.cba.exercise.domain.interactor

interface AbstractInteractor<T> {
    suspend fun execute(): T
}
