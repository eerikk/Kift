package com.kift.kift.events.list

import android.content.Context
import android.widget.FrameLayout
import com.kift.kift.R
import com.kift.kift.events.map.EventsMapContract
import com.kift.kift.events.map.EventsMapPresenter
import com.kift.kift.events.map.EventsMapState
import com.kift.storage.models.Category
import com.kift.storage.models.Event
import com.kift.storage.repository.EventRepo

@SuppressWarnings("ViewConstructor")
class EventsMapView(context: Context, eventRepo: EventRepo)
    : FrameLayout(context), EventsMapContract.View {

    private lateinit var presenter: EventsMapContract.Presenter

    init {
        inflate(context, R.layout.view_events_map, this)
        setupPresenter(eventRepo)
    }

    private fun setupPresenter(eventRepo: EventRepo) {
        presenter = EventsMapPresenter(eventRepo)
    }

    fun categoryChosen(category: Category) {
        presenter.categoryChosen(category)
    }

    override fun showState(eventsState: EventsMapState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openEventActivity(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}