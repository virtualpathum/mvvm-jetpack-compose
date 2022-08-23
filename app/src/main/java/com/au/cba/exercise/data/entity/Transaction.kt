package com.au.cba.exercise.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_transaction")
data class Transaction(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("atmId")
    val atmId: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("effectiveDate")
    val effectiveDate: String,
    @SerializedName("isPending")
    val isPending: Boolean
)