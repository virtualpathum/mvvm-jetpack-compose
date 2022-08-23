package com.au.cba.exercise.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.au.cba.exercise.FakeTransactionService
import com.au.cba.exercise.base.Resource
import com.au.cba.exercise.data.datasource.RemoteDataSource
import com.au.cba.exercise.data.datasource.RemoteDataSourceImpl
import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.data.repository.TransactionRepositoryImpl
import com.au.cba.exercise.data.service.TransactionService
import com.au.cba.exercise.domain.interactor.GetTransactionUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.test.runTest
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class TransactionViewModelTest {

    @Mock
    private lateinit var viewModel: TransactionViewModel
    @Mock
    private lateinit var getDataUseCase: GetTransactionUseCase
    @Mock
    private lateinit var repository: TransactionRepositoryImpl
    @Mock
    private lateinit var remoteDataSource: RemoteDataSource
    @Mock
    private lateinit var transactionService: TransactionService

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule = MainDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        transactionService = Mockito.mock(FakeTransactionService::class.java)
        remoteDataSource = RemoteDataSourceImpl(transactionService)
        repository = TransactionRepositoryImpl(remoteDataSource)
        getDataUseCase = GetTransactionUseCase(repository)
        viewModel = TransactionViewModel(getDataUseCase,mainCoroutineRule.testDispatcherProvider)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should return a flow of response`() = runTest {
        viewModel.data.collectIndexed { index, value ->

            if (index == 0) assertThat(value).isEqualTo(Resource.Error("",""))

            if (index == 1) assertThat(value).isEqualTo(Resource.Success(TransactionList))

            if (index == 2) assertThat(value).isEqualTo(Resource.Error("",""))
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data returns from the flow should not be empty`() = runTest {
        viewModel.data.collect {

        }
    }

}