package com.kift.kift

import android.app.Application
import com.kift.storage.StorageProvider

/**
 * Created by Eerik on 23/09/17.
 */
class App : Application(){

    companion object {
        lateinit var storageProvider : StorageProvider
    }

    override fun onCreate() {
        super.onCreate()
        storageProvider = StorageProvider(this)
    }
}