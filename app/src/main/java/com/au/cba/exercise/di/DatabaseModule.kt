package com.au.cba.exercise.di

import android.content.Context
import androidx.room.Room
import com.au.cba.exercise.data.db.TransactionDao
import com.au.cba.exercise.data.db.TransactionDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):TransactionDatabase{
        return Room.databaseBuilder(context,TransactionDatabase::class.java,"cbd_transaction")
            //.addTypeConverter(Converters())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideTransactionDAO(transactionDatabase: TransactionDatabase): TransactionDao {
        return transactionDatabase.transactionDAO()
    }
}