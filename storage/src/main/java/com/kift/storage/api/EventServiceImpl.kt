package com.kift.storage.api

import com.kift.storage.models.DataType
import com.kift.storage.models.EventsData
import io.reactivex.Single

/**
 * Created by Eerik on 14/10/17.
 */
class EventServiceImpl(private val kiftService: KiftService)
    : EventService {

    override fun getEvents(): Single<EventsData> {
        return kiftService.getEvents()
                .map { EventsData(it.list, DataType.SERVICE) }
    }

}