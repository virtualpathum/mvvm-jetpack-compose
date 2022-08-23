package com.au.cba.exercise.data.repository


import com.au.cba.exercise.data.datasource.RemoteDataSource
import com.au.cba.exercise.data.entity.TransactionList
import javax.inject.Inject

//TODO handle the three data sources. I assumed there will be separate data sources to handle the local db and cache.
//For this assignment I used only the remote data source
class TransactionRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    //private val localDataSource: LocalDataSource,
    //private val cacheDataSource: CacheDataSource
    ):TransactionRepository {

    override suspend fun getAll(): TransactionList = remoteDataSource.getAll()

}