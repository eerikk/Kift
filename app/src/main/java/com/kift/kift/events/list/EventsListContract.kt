package com.kift.kift.events.list

import com.kift.storage.models.Event

/**
 * Created by Eerik on 21/10/17.
 */

class EventsListContract {

    interface View {
        fun showState()
    }

    interface Presenter {
        fun onEventClick(event: Event)
    }
}