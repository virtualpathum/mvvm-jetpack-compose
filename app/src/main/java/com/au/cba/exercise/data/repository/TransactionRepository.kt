package com.au.cba.exercise.data.repository

import com.au.cba.exercise.data.entity.TransactionList

//Repository to handle the transaction
interface TransactionRepository:AbstractRepository<TransactionList> {

    override suspend fun getAll(): TransactionList

}