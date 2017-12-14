package com.kift.storage.repository

import com.kift.storage.api.EventService
import com.kift.storage.models.EventsData
import com.kift.storage.storage.EventStorage
import io.reactivex.Observable

/**
 * Created by Eerik on 28/11/17.
 */
class EventRepoImpl(private val eventsStorage: EventStorage,
                    private val eventService: EventService)
    : EventRepo {

    override fun getEventsData(): Observable<EventsData> =
            Observable.concat(getStorageObservable(), getServiceObservable())

    private fun getStorageObservable(): Observable<EventsData> =
            eventsStorage.getEventsData()
                    .filter { it.eventsList.isNotEmpty() }
                    .toObservable()

    private fun getServiceObservable(): Observable<EventsData> =
            eventService.getEvents()
                    .filter { it.eventsList.isNotEmpty() }
                    .doOnSuccess { eventsStorage.saveEvents(it.eventsList) }
                    .toObservable()

}