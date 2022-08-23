package com.au.cba.exercise.shared

import com.au.cba.exercise.base.DefaultDispatcherProvider
import com.au.cba.exercise.base.DispatcherProvider
import com.au.cba.exercise.presentation.viewmodel.TransactionViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [TransactionViewModel::class]
)
abstract class FakeViewModel {
    @Singleton
    @Binds
    abstract fun bindViewModel(
        fakeUseCase: FakeUseCase,
        dispatchers: DispatcherProvider = DefaultDispatcherProvider()
    ): TransactionViewModel
}