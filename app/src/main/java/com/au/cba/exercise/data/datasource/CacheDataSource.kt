package com.au.cba.exercise.data.datasource


import com.au.cba.exercise.data.entity.TransactionList

//Interface to define caching functions
//TODO:Need to implement
interface CacheDataSource {
    suspend fun getAll(): List<TransactionList>

}