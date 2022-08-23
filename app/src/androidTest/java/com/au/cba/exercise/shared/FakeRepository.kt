package com.au.cba.exercise.shared

import com.au.cba.exercise.data.entity.TransactionList

class FakeRepository(private val fakeRemoteDateSource: FakeRemoteDateSource) {

    fun getTransaction():TransactionList{
        return fakeRemoteDateSource.getTransaction()
    }

}