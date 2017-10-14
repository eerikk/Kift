package com.kift.storage.models

import com.kift.storage.helpers.mocks.DATE
import com.kift.storage.helpers.mocks.EVENT_KIFT
import com.kift.storage.helpers.mocks.LOCATION
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Eerik on 14/10/17.
 */

class EventTest {

    @Test
    fun test(){
        val event = EVENT_KIFT
        assertEquals(123, event.id)
        assertEquals("1111", event.facebookId)
        assertEquals("kift event", event.title)
        assertEquals("happening soon ", event.description)
        assertEquals(15, event.attendingCount)
        assertEquals(20, event.interestedCount)
        assertEquals("image-url", event.image)
        assertEquals(LOCATION, event.location)
        assertEquals(DATE, event.startTime)
        assertEquals(DATE, event.endTime)
        assertEquals(DATE, event.updateTime)
        assertEquals(listOf(Category.KIFT), event.category)
        assertEquals(10.toFloat(), event.ticketPrice)
        assertEquals("ticket-info-url", event.ticketInfo)
    }
}