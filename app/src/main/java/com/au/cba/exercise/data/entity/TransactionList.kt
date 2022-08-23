package com.au.cba.exercise.data.entity

import com.google.gson.annotations.SerializedName

data class TransactionList(
    @SerializedName("account")
    val account: Account?,
    @SerializedName("atms")
    val atms: List<Atm>,
    @SerializedName("transactions")
    val transactions: List<Transaction>

){
    companion object{
        val EMPTY = TransactionList(null, emptyList(), emptyList())
    }
}
