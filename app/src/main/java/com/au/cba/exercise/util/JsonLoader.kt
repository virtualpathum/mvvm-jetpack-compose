package com.au.cba.exercise.util

import android.content.Context
import java.io.IOException

//Temporary class
class JsonLoader{
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val json: String
        try {
            json = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return json
    }
}




