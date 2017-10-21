package com.kift.kift.events

import com.kift.storage.models.Category

/**
 * Created by Eerik on 01/10/17.
 */
data class EventsState(
        var isLoading: Boolean = false,
        val category: Category)