package com.au.cba.exercise.data.datasource

import com.au.cba.exercise.data.entity.Transaction


//Interface to define local data source functions :eg handle room
//TODO:Need to implement
interface LocalDataSource {
    suspend fun getAll(): List<Transaction>
}