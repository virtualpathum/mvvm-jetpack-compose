package com.au.cba.exercise.shared

class FakeUseCase(private val fakeRepository: FakeRepository) {
    fun getTransactions(){
        fakeRepository.getTransaction()
    }
}