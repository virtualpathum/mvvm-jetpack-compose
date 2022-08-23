package com.au.cba.exercise.data.service

import com.au.cba.exercise.data.entity.TransactionList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitHandler(baseURL:String):Callback<TransactionList> {

    override fun onResponse(call: Call<TransactionList>, response: Response<TransactionList>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<TransactionList>, t: Throwable) {
        TODO("Not yet implemented")
    }

}