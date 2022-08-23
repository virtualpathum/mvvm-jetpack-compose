package com.au.cba.exercise.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.au.cba.exercise.data.entity.Transaction

//TODO:When using Room, complete the remaining functions
@Dao
interface TransactionDao {

    @Query("SELECT * FROM tbl_transaction")
    suspend fun getTransactions():List<Transaction>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(list:List<Transaction>)

    //TODO:Define functions to persist and retrieve Account,ATM and Location data

}