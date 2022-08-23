package com.au.cba.exercise.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_atm")
data class Atm(

    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("address")
    val address: String,
    //@SerializedName("location")
    //val location: Location,
    @SerializedName("name")
    val name: String

)