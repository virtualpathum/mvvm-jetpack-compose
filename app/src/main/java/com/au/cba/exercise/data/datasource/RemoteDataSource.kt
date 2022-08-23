package com.au.cba.exercise.data.datasource


import com.au.cba.exercise.data.entity.TransactionList

//Interface to remote functions
//TODO:Need to implement
interface RemoteDataSource {

    suspend fun getAll(): TransactionList

}