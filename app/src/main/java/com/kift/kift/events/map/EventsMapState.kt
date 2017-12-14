package com.kift.kift.events.map

import com.kift.storage.models.Category
import com.kift.storage.models.Event
import com.kift.storage.models.EventsData

/**
 * Created by Eerik on 04/12/17.
 */

data class EventsMapState(
        val isLoading: Boolean = false,
        val category: Category,
        val eventsData: EventsData,
        val activeMarker: Event? = null
)