package com.au.cba.exercise.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.au.cba.exercise.base.DefaultDispatcherProvider
import com.au.cba.exercise.base.DispatcherProvider
import com.au.cba.exercise.base.Resource
import com.au.cba.exercise.domain.interactor.GetTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val getTransactionUseCase: GetTransactionUseCase,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) : ViewModel() {


    var data = flow {
        emit(Resource.Loading(true))
        val data = getTransactionUseCase.execute()
        emit(Resource.Success(data))
    }.flowOn(dispatchers.io()).catch {
        emit(Resource.Error(it.message.toString()))
    }


    fun refreshData() {
        Log.i("MyTag", "Refreshing Data")
    }
}