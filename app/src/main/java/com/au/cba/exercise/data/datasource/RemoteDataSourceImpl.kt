package com.au.cba.exercise.data.datasource

import com.au.cba.exercise.App
import com.au.cba.exercise.util.JsonLoader
import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.data.service.TransactionService
import com.google.gson.Gson
import javax.inject.Inject

//TODO:When TransactionService fetch the data from the given end point, use the transactionService.getAll()
//FIXME: Temporarily added this json reader logic to parse the local json file stored in the asset folder, so the remaining functionality can work
class RemoteDataSourceImpl @Inject constructor(
    private val transactionService: TransactionService
) : RemoteDataSource {
    override suspend fun getAll(): TransactionList {
        return getTransactionListFromLocalJson()
    }//= transactionService.getAll()

    //Temporary function to read the local json
    private fun getTransactionListFromLocalJson():TransactionList{
        val json = JsonLoader().getJsonDataFromAsset(App.appContext, "exercise.json")
        return Gson().fromJson(json, TransactionList::class.java)
    }
}