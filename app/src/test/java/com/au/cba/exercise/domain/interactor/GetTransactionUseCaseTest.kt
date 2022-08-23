package com.au.cba.exercise.domain.interactor

import com.au.cba.exercise.data.repository.TransactionRepositoryImpl
import com.au.cba.exercise.presentation.viewmodel.MainDispatcherRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetTransactionUseCaseTest {

    @Mock
    private lateinit var getDataUseCase: GetTransactionUseCase

    @Mock
    private lateinit var transactionRepositoryImpl: TransactionRepositoryImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule = MainDispatcherRule()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(mainCoroutineRule.testDispatcher)
        transactionRepositoryImpl = Mockito.mock(TransactionRepositoryImpl::class.java)
        getDataUseCase = GetTransactionUseCase(transactionRepositoryImpl)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should return a response`() = runTest {
        assertNotNull(getDataUseCase.execute())
    }
}