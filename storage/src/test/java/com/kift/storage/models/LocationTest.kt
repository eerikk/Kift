package com.kift.storage.models

import com.kift.storage.helpers.mocks.LOCATION
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Eerik on 14/10/17.
 */

class LocationTest {

    @Test
    fun test() {
        val location = LOCATION
        assertEquals("Kelm", location.name)
        assertEquals("Tallinn", location.city)
        assertEquals("Estonia", location.country)
        assertEquals(123456.toFloat(), location.latitude)
        assertEquals(654321.toFloat(), location.longitude)
        assertEquals("Vene tänav", location.street)
        assertEquals("1423", location.zip)
    }
}