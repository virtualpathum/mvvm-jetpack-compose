package com.au.cba.exercise.domain.interactor

import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.data.repository.TransactionRepository
import javax.inject.Inject

class GetTransactionUseCase @Inject constructor(private val transactionRepository: TransactionRepository):AbstractInteractor<TransactionList> {

   override suspend fun execute(): TransactionList=  transactionRepository.getAll()

}