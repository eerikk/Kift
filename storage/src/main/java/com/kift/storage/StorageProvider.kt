package com.kift.storage

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.kift.storage.api.ApiClient
import com.kift.storage.api.EventService
import com.kift.storage.api.EventServiceImpl
import com.kift.storage.repository.EventRepo
import com.kift.storage.repository.EventRepoImpl
import com.kift.storage.storage.EventStorage
import com.kift.storage.storage.EventStorageImpl
import com.kift.storage.storage.LocalStorage
import com.kift.storage.storage.LocalStorageImpl

/**
 * Created by Eerik on 23/09/17.
 */
class StorageProvider(context: Context) {

    private val gson = Gson()

    private val SHARED_PREFERENCES = "shared_preferences"

    private val sharedPreferences: SharedPreferences
    private val localStorage: LocalStorage
    private val eventStorage: EventStorage
    private val eventService: EventService
    private val apiClient: ApiClient
    val eventRepo: EventRepo

    init {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        localStorage = LocalStorageImpl(sharedPreferences, gson)
        apiClient = ApiClient()
        eventStorage = EventStorageImpl(localStorage)
        eventService = EventServiceImpl(apiClient.service)
        eventRepo = EventRepoImpl(eventStorage, eventService)
    }
}