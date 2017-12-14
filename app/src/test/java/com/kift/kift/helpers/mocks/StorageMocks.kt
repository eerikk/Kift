package com.kift.storage.helpers.mocks

import com.kift.storage.models.Category
import com.kift.storage.models.Event
import com.kift.storage.models.Location
import java.util.*

/**
 * Created by Eerik on 14/10/17.
 */

/**
 * CHANGING ALREADY CREATED MOCK-DATA WILL BREAK TESTS
 */
val LOCATION = Location("Kelm", "Tallinn", "Estonia",
        123456.toFloat(), 654321.toFloat(), "Vene tänav", "1423")

val FIXED_DATE_LONG = 1507972803408
val DATE = Date(FIXED_DATE_LONG)

val EVENT_KIFT = Event(123, "1111", "kift event", "happening soon ",
        15, 20, "image-url", LOCATION, DATE, DATE, DATE,
        listOf(Category.KIFT), 10.toFloat(), "ticket-info-url")

val EVENT_DANCE = Event(124, "22222", "dance event", "dance all night",
        15, 20, "image-url-2", LOCATION, DATE, DATE, DATE,
        listOf(Category.DANCE), 10.toFloat(), "ticket-info-url")

val EVENT_SPORT = Event(126, "33333", "sport event", "run all day",
        15, 20, "image-url-3", LOCATION, DATE, DATE, DATE,
        listOf(Category.SPORT), 10.toFloat(), "ticket-info-url")

val EVENT_MULTIPLE_CATEGORIES = Event(125, "113333311", "multiple categories", "so cool event, come",
        15, 20, "image-url-2", LOCATION, DATE, DATE, DATE,
        listOf(Category.KIFT, Category.DANCE), 10.toFloat(), "ticket-info-url")

val EVENTS_JSON_EMPTY = "[]"
val EVENTS_JSON = "[{\"id\":123,\"facebookId\":\"1111\"," +
        "\"title\":\"kift event\",\"description\":\"happening soon \"," +
        "\"attendingCount\":15,\"interestedCount\":20,\"image\":\"image-url\"," +
        "\"location\":{\"name\":\"Kelm\",\"city\":\"Tallinn\",\"country\":\"Estonia\"," +
        "\"latitude\":123456.0,\"longitude\":654321.0,\"street\":\"Vene tänav\"," +
        "\"zip\":\"1423\"},\"startTime\":\"Oct 14, 2017 12:20:03 PM\"," +
        "\"endTime\":\"Oct 14, 2017 12:20:03 PM\"," +
        "\"updateTime\":\"Oct 14, 2017 12:20:03 PM\"," +
        "\"category\":[\"KIFT\"],\"ticketPrice\":10.0," +
        "\"ticketInfo\":\"ticket-info-url\"}]"

