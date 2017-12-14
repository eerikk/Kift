package com.kift.kift.events.list

import com.kift.storage.helpers.mocks.EVENT_DANCE
import com.kift.storage.helpers.verify
import com.kift.storage.repository.EventRepo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Eerik on 04/12/17.
 */
@RunWith(MockitoJUnitRunner::class)
class EventsListPresenterTest {

    @Mock lateinit var view: EventsListContract.View
    lateinit var presenter: EventsListPresenter


    @Mock lateinit var eventRepo: EventRepo

    val EVENT = EVENT_DANCE

    @Before
    fun setUp() {
        presenter = EventsListPresenter(eventRepo)
        presenter.view = view
    }

    @Test
    fun onEventClick() {
        presenter.onEventClick(EVENT)
        verify(view).openEventActivity(EVENT)
    }
}