package com.au.cba.exercise.di

import com.au.cba.exercise.data.datasource.RemoteDataSource
import com.au.cba.exercise.data.repository.TransactionRepository
import com.au.cba.exercise.data.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTransactionRepository(
        remoteDataSource: RemoteDataSource,
    ): TransactionRepository {
        return TransactionRepositoryImpl(remoteDataSource)
    }
}