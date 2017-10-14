package com.kift.storage.storage

/**
 * Created by Eerik on 01/10/17.
 */
interface LocalStorage {
    fun <T> saveList(list: List<T>, klass: Class<T>)
    fun <T> loadList(klass: Class<T>): List<T>
}