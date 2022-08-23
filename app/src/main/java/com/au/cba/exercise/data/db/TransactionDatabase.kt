package com.au.cba.exercise.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.au.cba.exercise.data.entity.Account
import com.au.cba.exercise.data.entity.Atm
import com.au.cba.exercise.data.entity.Transaction

//TODO: define other DAOs when they are ready
@Database(entities = [Transaction::class, Account::class, Atm::class], version = 1, exportSchema = false)
abstract class TransactionDatabase:RoomDatabase() {
    abstract fun transactionDAO(): TransactionDao
}