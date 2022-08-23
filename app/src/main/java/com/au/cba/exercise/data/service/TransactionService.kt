package com.au.cba.exercise.data.service

import com.google.gson.JsonObject
import retrofit2.Callback
import retrofit2.http.GET


//Retrofit service to manage the end points.
//FIXME: couldn't load the data remotely. Endpoint seems not proper to handle the GET
interface TransactionService {

    //@GET("exercise.json?dl=1")
    //suspend fun getAll(): TransactionList

    @GET("exercise.json?dl=1")
    fun getAll(response: Callback<JsonObject?>?)

}