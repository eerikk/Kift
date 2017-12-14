package com.kift.storage.api

import com.kift.storage.models.Event

/**
 * Created by Eerik on 28/11/17.
 */
data class EventsResponseSuccess(
        val list: List<Event>
)