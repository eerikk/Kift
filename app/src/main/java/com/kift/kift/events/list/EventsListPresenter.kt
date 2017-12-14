package com.kift.kift.events.list

import com.kift.storage.models.Category
import com.kift.storage.models.Event
import com.kift.storage.repository.EventRepo

/**
 * Created by Eerik on 04/12/17.
 */
class EventsListPresenter(eventRepo: EventRepo)
    : EventsListContract.Presenter {

    lateinit var view: EventsListContract.View

    override fun onEventClick(event: Event) {
        view.openEventActivity(event)
    }

    override fun onCategoryChosen(category: Category) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}