package com.au.cba.exercise

import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.data.service.TransactionService
import com.au.cba.exercise.util.JsonLoader
import com.google.gson.Gson

//TODO:Added to testing purpose only. To be refactored
class FakeTransactionService : TransactionService {

    override suspend fun getAll(): TransactionList {
        val jsonFileString = JsonLoader().getJsonDataFromAsset(App.appContext, "exercise.json")
        val gson = Gson()
        return gson.fromJson(jsonFileString, TransactionList::class.java)
    }
}