package com.kift.kift.events.list

import com.kift.storage.models.Event

/**
 * Created by Eerik on 21/10/17.
 */
class EventsListPresenter(val view: EventsListView) : EventsListContract.Presenter {

    override fun onEventClick(event: Event) {
        view.showState()
    }

}