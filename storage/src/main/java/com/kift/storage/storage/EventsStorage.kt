package com.kift.storage.storage

import com.kift.storage.models.Category
import com.kift.storage.models.Event
import io.reactivex.Single

/**
 * Created by Eerik on 01/10/17.
 */
interface EventsStorage {

    @Throws(EventNotFoundException::class)
    fun getEvent(id: Long): Single<Event>

    fun getAllEvents(): Single<List<Event>>

    fun getEvents(category: Category): Single<List<Event>>
}

class EventNotFoundException : RuntimeException()