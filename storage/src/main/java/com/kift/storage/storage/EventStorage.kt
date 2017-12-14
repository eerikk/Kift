package com.kift.storage.storage

import com.kift.storage.models.Event
import com.kift.storage.models.EventsData
import io.reactivex.Single

/**
 * Created by Eerik on 01/10/17.
 */
interface EventStorage {

    @Throws(EventListEmptyException::class)
    fun saveEvents(list: List<Event>)

    fun getEventsData(): Single<EventsData>

}

class EventListEmptyException : RuntimeException()