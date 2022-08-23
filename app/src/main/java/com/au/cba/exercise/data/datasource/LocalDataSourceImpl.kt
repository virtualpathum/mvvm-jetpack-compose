package com.au.cba.exercise.data.datasource

import com.au.cba.exercise.data.db.TransactionDao
import com.au.cba.exercise.data.entity.Transaction
import javax.inject.Inject

//TODO:Get all entities from Room using the DAO and construct the transaction list here.
class LocalDataSourceImpl @Inject constructor(private val transactionDao: TransactionDao):LocalDataSource {
    //For now just defined the getTransaction()
    override suspend fun getAll(): List<Transaction> = transactionDao.getTransactions()


}