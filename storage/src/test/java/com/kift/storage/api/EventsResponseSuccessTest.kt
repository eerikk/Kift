package com.kift.storage.api

import com.kift.storage.helpers.mocks.DATE
import com.kift.storage.helpers.mocks.EVENT_KIFT
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Eerik on 14/10/17.
 */
class EventsResponseSuccessTest {

    val events = List(4, { EVENT_KIFT })

    @Test
    fun test() {
        val response = EventsResponseSuccess(Status.SUCCESS, events, DATE)
        assertEquals(Status.SUCCESS, response.status)
        assertEquals(events, response.data)
        assertEquals(DATE, response.lastUpdated)
    }
}