package com.kift.kift.events.list

import com.kift.storage.models.Category
import com.kift.storage.models.EventsData

/**
 * Created by Eerik on 04/12/17.
 */

data class EventsListState(
        val isLoading: Boolean = false,
        val category: Category,
        val eventsData: EventsData
)