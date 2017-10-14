package com.kift.storage.models

/**
 * Created by Eerik on 10/10/17.
 */
data class Location(
        val name: String,
        val city: String,
        val country: String,
        val latitude: Float,
        val longitude: Float,
        val street: String,
        val zip: String)