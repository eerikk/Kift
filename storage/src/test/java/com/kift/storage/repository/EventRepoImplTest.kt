package com.kift.storage.repository

import com.kift.storage.api.EventService
import com.kift.storage.storage.EventStorage
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Eerik on 28/11/17.
 */
@RunWith(MockitoJUnitRunner::class)
class EventRepoImplTest {

    @Mock private lateinit var eventStorage: EventStorage
    @Mock private lateinit var eventService: EventService

    private lateinit var eventRepo: EventRepo

    @Before
    fun setUp() {
        eventRepo = EventRepoImpl(eventStorage, eventService)
    }

}