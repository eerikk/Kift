package com.kift.storage.storage

import com.kift.storage.helpers.mock
import com.kift.storage.helpers.mocks.EVENT_DANCE
import com.kift.storage.helpers.mocks.EVENT_KIFT
import com.kift.storage.helpers.mocks.EVENT_MULTIPLE_CATEGORIES
import com.kift.storage.helpers.mocks.EVENT_SPORT
import com.kift.storage.helpers.whenever
import com.kift.storage.models.Category
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
    val multipleCategoriesEvent = EVENT_MULTIPLE_CATEGORIES

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
    fun getEvent_eventInList() {
        provideEventsList(listOf(kiftEvent, danceEvent))
        assertEquals(kiftEvent, eventStorage.getEvent(kiftEvent.id).blockingGet())
    }

    @Test(expected = EventNotFoundException::class)
    fun getEvent_eventNotInList() {
        provideEventsList(listOf(kiftEvent))
        eventStorage.getEvent(sportEvent.id).blockingGet()
    }

    @Test
    fun getAllEvents() {
        provideEventsList(listOf(kiftEvent, danceEvent))
        assertEquals(listOf(kiftEvent, danceEvent),
                eventStorage.getAllEvents().blockingGet())
    }

    @Test
    fun getEvents_multipleCategory() {
        provideEventsList(
                listOf(kiftEvent, danceEvent, multipleCategoriesEvent))

        assertEquals(listOf(kiftEvent, multipleCategoriesEvent),
                eventStorage.getEvents(Category.KIFT).blockingGet())
    }

    @Test
    fun getEvents_singleCategory() {
        provideEventsList(
                listOf(kiftEvent, sportEvent, multipleCategoriesEvent))

        assertEquals(listOf(sportEvent),
                eventStorage.getEvents(Category.SPORT).blockingGet())
    }

    @Test
    fun getEvents_noEvents() {
        provideEventsList(emptyList())
        assertEquals(emptyList<Event>(), eventStorage.getAllEvents().blockingGet())
    }

}