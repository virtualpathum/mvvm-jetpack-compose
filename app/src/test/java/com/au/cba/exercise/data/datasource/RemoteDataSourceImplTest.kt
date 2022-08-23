package com.au.cba.exercise.data.datasource


import com.au.cba.exercise.presentation.viewmodel.MainDispatcherRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteDataSourceImplTest {

    @Mock
    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule = MainDispatcherRule()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(mainCoroutineRule.testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should return a response`() = runTest {
        Assert.assertNotNull(remoteDataSourceImpl.getAll())
    }
}