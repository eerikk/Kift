package com.kift.storage.storage

import android.content.SharedPreferences
import com.google.gson.Gson
import com.kift.storage.ListParameterizedType

/**
 * Created by Eerik on 01/10/17.
 */
class LocalStorageImpl(val sharedPrefs: SharedPreferences, val gson: Gson) : LocalStorage {

    private val EMPTY_LIST = ""

    override fun <T> saveList(list: List<T>, klass: Class<T>) {
        sharedPrefs.edit().putString(klass.simpleName, gson.toJson(list))
                .apply()
    }

    override fun <T> loadList(klass: Class<T>): List<T> {
        val listJson = sharedPrefs.getString(klass.simpleName, EMPTY_LIST)
        val listType = ListParameterizedType(klass)
        return try {
            gson.fromJson<List<T>>(listJson, listType)
        } catch (e: Exception) {
            emptyList()
        }
    }

}