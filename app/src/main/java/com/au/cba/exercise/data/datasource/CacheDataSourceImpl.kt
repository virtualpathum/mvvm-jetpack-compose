package com.au.cba.exercise.data.datasource

import com.au.cba.exercise.data.entity.TransactionList
import javax.inject.Inject

//TODO:Implement caching
class CacheDataSourceImpl @Inject constructor():CacheDataSource {
    override suspend fun getAll(): List<TransactionList> {
        TODO("Not yet implemented")
    }

}