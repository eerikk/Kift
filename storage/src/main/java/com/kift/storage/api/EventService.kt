package com.kift.storage.api

import com.kift.storage.models.EventsData
import io.reactivex.Single

/**
 * Created by Eerik on 14/10/17.
 */
interface EventService {

    fun getEvents(): Single<EventsData>
}