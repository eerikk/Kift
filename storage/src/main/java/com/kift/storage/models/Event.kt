package com.kift.storage.models

import java.util.*

/**
 * Created by Eerik on 01/10/17.
 */
data class Event(
        val id: Long,
        val facebookId: String,
        val title: String,
        val description: String,
        val attendingCount: Int,
        val interestedCount: Int,
        val image: String,
        val location: Location,
        val startTime: Date,
        val endTime: Date,
        val updateTime: Date,
        val category: List<Category>,
        val ticketPrice: Float,
        val ticketInfo: String)

enum class Category {
    KIFT,
    DANCE,
    CONCERT,
    SPORT,
}