package com.au.cba.exercise.di


import com.au.cba.exercise.data.datasource.*
import com.au.cba.exercise.data.db.TransactionDao
import com.au.cba.exercise.data.service.TransactionService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideCacheDataSource(): CacheDataSource {
        return CacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(transactionDao: TransactionDao): LocalDataSource {
        return LocalDataSourceImpl(transactionDao)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(transactionService: TransactionService): RemoteDataSource {
        return RemoteDataSourceImpl(transactionService)
    }
}