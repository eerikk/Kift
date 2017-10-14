package com.kift.storage.api

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Eerik on 14/10/17.
 */
class EventsResponseErrorTest {

    val ERROR_MSG = "server is down, I repeat server is down"

    @Test
    fun test() {
        val response = EventsResponseError(Status.ERROR, ERROR_MSG)
        assertEquals(Status.ERROR, response.status)
        assertEquals(ERROR_MSG, response.message)
    }
}