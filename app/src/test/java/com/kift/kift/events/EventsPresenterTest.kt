package com.kift.kift.events

import com.kift.storage.StorageProvider
import com.kift.storage.models.Category
import com.kift.storage.models.Event
import org.junit.Before
import org.junit.Test
import uk.co.envoplan.habitaction.helpers.mockito.mock
import uk.co.envoplan.habitaction.helpers.mockito.verify
import java.util.*

/**
 * Created by Eerik on 01/10/17.
 */
class EventsPresenterTest {

    lateinit var event: Event
    val chosenCategory: Category = Category.KIFT

    lateinit var view: EventsContract.View
    lateinit var presenter: EventsContract.Presenter

    lateinit var storageProvider : StorageProvider

    @Before
    fun setUp() {
        view = mock()
//        presenter = EventsPresenter(storageProvider)
        presenter.setView(view)
    }


    @Test
    fun onEventClick() {
        presenter.onEventClick(event)
        verify(view).openEventActivity(event)
    }

    @Test
    fun onCategoryClick_hasCachedData() {
        presenter.onCategoryClick(chosenCategory)
        verify(view).showState(EventsState(
                isLoading = false,
                category = chosenCategory))
    }

    @Test
    fun onCategoryClick_noCachedData() {
        presenter.onCategoryClick(chosenCategory)
        verify(view).showState(EventsState(
                isLoading = true,
                category = chosenCategory
        ))
    }

    @Test
    fun onMapClick() {
        presenter.onMapClick()
        verify(view).openMapActivity()
    }

}