package com.au.cba.exercise.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_account")
data class Account(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("accountName")
    val accountName: String,
    @SerializedName("accountNumber")
    val accountNumber: String,
    @SerializedName("available")
    val available: String,
    @SerializedName("balance")
    val balance: String,
    @SerializedName("bsb")
    val bsb: String
)