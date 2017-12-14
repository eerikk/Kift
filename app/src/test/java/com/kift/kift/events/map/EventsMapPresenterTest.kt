package com.kift.kift.events.map

import com.kift.storage.helpers.mocks.EVENT_KIFT
import com.kift.storage.helpers.verify
import com.kift.storage.models.Category
import com.kift.storage.models.DataType
import com.kift.storage.models.EventsData
import com.kift.storage.repository.EventRepo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Eerik on 05/12/17.
 */
@RunWith(MockitoJUnitRunner::class)
class EventsMapPresenterTest {

    @Mock lateinit var view: EventsMapContract.View
    lateinit var presenter: EventsMapPresenter

    @Mock lateinit var eventRepo: EventRepo

    val EVENT = EVENT_KIFT

    val EVENTS_DATA = EventsData(listOf(EVENT), DataType.STORAGE)
    val CATEGORY = Category.CONCERT

    @Before
    fun setUp() {
        presenter = EventsMapPresenter(eventRepo, CATEGORY)
        presenter.view = view
    }

    @Test
    fun onMoreInfoClick() {
        presenter.onMoreInfoClick(EVENT)
        verify(view).openEventActivity(EVENT)
    }

    @Test
    fun onCloseInfoClick() {
        presenter.onCloseInfoClick()
        verify(view).showState(EventsMapState(
                isLoading = false,
                category = CATEGORY,
                eventsData = EVENTS_DATA,
                activeMarker = null)
        )
    }
}