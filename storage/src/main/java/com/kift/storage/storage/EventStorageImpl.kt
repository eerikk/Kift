package com.kift.storage.storage

import com.kift.storage.models.DataType
import com.kift.storage.models.Event
import com.kift.storage.models.EventsData
import io.reactivex.Single

/**
 * Created by Eerik on 01/10/17.
 */
class EventStorageImpl(private val localStorage: LocalStorage) : EventStorage {

    override fun saveEvents(list: List<Event>) {
        if (list.isNotEmpty())
            localStorage.saveList(list, Event::class.java)
        else
            throw EventListEmptyException()
    }

    override fun getEventsData(): Single<EventsData> =
            Single.just(EventsData(localStorage.loadList(Event::class.java),
                    DataType.STORAGE))

}