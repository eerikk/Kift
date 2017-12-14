package com.kift.kift.events.list

import com.kift.storage.models.Category
import com.kift.storage.models.Event

/**
 * Created by Eerik on 04/12/17.
 */
class EventsListContract {

    interface View {
        fun showState(eventsState: EventsListState)
        fun openEventActivity(event: Event)
    }

    interface Presenter {
        fun onEventClick(event: Event)
        fun onCategoryChosen(category: Category)
    }

}