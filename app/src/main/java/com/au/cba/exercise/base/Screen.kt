package com.au.cba.exercise.base

sealed class Screen(val route:String){
    object MainScreen:Screen("main")
    object DetailScreen:Screen("detail")

    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach {
                arg -> append("/$arg")
            }
        }
    }

}
