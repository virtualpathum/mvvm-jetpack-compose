package com.au.cba.exercise

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

//FIXME:Remove the temporary class body added to get the applicationContext for json reading
@HiltAndroidApp
class App:Application(){
    //TODO Remove
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    //TODO Remove
    companion object {

        lateinit var appContext: Context

    }
}