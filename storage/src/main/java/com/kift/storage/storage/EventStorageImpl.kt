package com.kift.storage.storage

import com.kift.storage.models.Category
import com.kift.storage.models.Event
import io.reactivex.Single

/**
 * Created by Eerik on 01/10/17.
 */
class EventStorageImpl(val localStorage: LocalStorage) : EventsStorage {

    override fun getEvent(id: Long): Single<Event> =
            Single.just(localStorage.loadList(Event::class.java)
                    .find { it.id == id } ?: throw EventNotFoundException())

    override fun getAllEvents(): Single<List<Event>> =
            Single.just(localStorage.loadList(Event::class.java))

    override fun getEvents(category: Category): Single<List<Event>> {
        val filteredList = getAllEvents().blockingGet()
                .filter { it.category.contains(category) }

        return Single.just(filteredList)
    }

}