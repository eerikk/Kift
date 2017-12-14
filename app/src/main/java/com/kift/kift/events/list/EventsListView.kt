package com.kift.kift.events.list

import android.annotation.SuppressLint
import android.content.Context
import android.widget.FrameLayout
import com.kift.kift.R
import com.kift.storage.models.Category
import com.kift.storage.models.Event
import com.kift.storage.repository.EventRepo

@SuppressLint("ViewConstructor")
class EventsListView(context: Context, eventRepo: EventRepo)
    : FrameLayout(context), EventsListContract.View {

    private lateinit var presenter: EventsListPresenter

    init {
        inflate(context, R.layout.view_events_list, this)
        setupPresenter(eventRepo)
    }

    private fun setupPresenter(eventRepo: EventRepo) {
        presenter = EventsListPresenter(eventRepo)
        presenter.view = this
    }

    fun categoryChosen(category: Category) {
        presenter.onCategoryChosen(category)
    }

    override fun showState(eventsListState: EventsListState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openEventActivity(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}