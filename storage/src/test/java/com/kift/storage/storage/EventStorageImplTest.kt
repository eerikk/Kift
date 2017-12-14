package com.kift.storage.storage

import com.kift.storage.helpers.mock
import com.kift.storage.helpers.mocks.EVENT_DANCE
import com.kift.storage.helpers.mocks.EVENT_KIFT
import com.kift.storage.helpers.mocks.EVENT_SPORT
import com.kift.storage.helpers.verify
import com.kift.storage.helpers.whenever
import com.kift.storage.models.Event
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


/**
 * Created by Eerik on 14/10/17.
 */
class EventStorageImplTest {

    val kiftEvent = EVENT_KIFT
    val danceEvent = EVENT_DANCE
    val sportEvent = EVENT_SPORT

    val eventsList = List(2, { kiftEvent })

    lateinit var localStorage: LocalStorage
    lateinit var eventStorage: EventStorageImpl

    @Before
    fun setUp() {
        localStorage = mock()
        eventStorage = EventStorageImpl(localStorage)
    }

    private fun provideEventsList(eventList: List<Event>) {
        whenever(localStorage.loadList(Event::class.java)).thenReturn(eventList)
    }


    @Test
    fun saveEvents_hasEvents() {
        eventStorage.saveEvents(eventsList)
        verify(localStorage).saveList(eventsList, Event::class.java)
    }

    @Test(expected = EventListEmptyException::class)
    fun saveEvents_emptyList() {
        eventStorage.saveEvents(emptyList())
    }


    @Test
    fun getAllEvents() {
        provideEventsList(listOf(kiftEvent, danceEvent))
        assertEquals(listOf(kiftEvent, danceEvent),
                eventStorage.getEventsData().blockingGet())
    }

    @Test
    fun getEvents_noEvents() {
        provideEventsList(emptyList())
        assertEquals(emptyList<Event>(), eventStorage.getEventsData().blockingGet())
    }

}