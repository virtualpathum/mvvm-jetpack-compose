package com.au.cba.exercise.shared

import com.au.cba.exercise.App
import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.util.JsonLoader
import com.google.gson.Gson

//TODO:Fix to load from actual service
class FakeRemoteDateSource(private val fakeTransactionService: FakeTransactionService) {
    fun getTransaction(): TransactionList {
        //fakeTransactionService.getAll()
        val jsonFileString = JsonLoader().getJsonDataFromAsset(App.appContext, "exercise.json")
        val gson = Gson()
        return gson.fromJson(jsonFileString, TransactionList::class.java)

    }
}