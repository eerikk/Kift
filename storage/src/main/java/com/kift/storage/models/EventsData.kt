package com.kift.storage.models

/**
 * Created by Eerik on 28/11/17.
 */
data class EventsData(
        var eventsList: List<Event>,
        val type: DataType
)

enum class DataType {
    STORAGE,
    SERVICE
}