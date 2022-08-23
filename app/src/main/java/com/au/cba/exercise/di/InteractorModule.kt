package com.au.cba.exercise.di

import com.au.cba.exercise.data.repository.TransactionRepository
import com.au.cba.exercise.domain.interactor.GetTransactionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InteractorModule {

    @Provides
    @Singleton
    fun provideTransactionUseCase(transactionRepository: TransactionRepository)
    :GetTransactionUseCase = GetTransactionUseCase(transactionRepository)
}