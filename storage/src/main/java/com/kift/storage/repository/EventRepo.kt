package com.kift.storage.repository

import com.kift.storage.models.EventsData
import io.reactivex.Observable

/**
 * Created by Eerik on 28/11/17.
 */

interface EventRepo {
    fun getEventsData(): Observable<EventsData>
}