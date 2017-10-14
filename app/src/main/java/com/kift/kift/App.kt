package com.kift.kift

import android.app.Application

/**
 * Created by Eerik on 23/09/17.
 */
class App : Application(){

    companion object {
        //TODO
    }

    override fun onCreate() {
        super.onCreate()
        println("app created")
    }
}