package com.kift.kift.events.map

import com.kift.storage.models.Category
import com.kift.storage.models.Event

/**
 * Created by Eerik on 04/12/17.
 */
class EventsMapContract {

    interface View {
        fun showState(eventsState: EventsMapState)
        fun openEventActivity(event: Event)
    }

    interface Presenter {
        fun onMarkerClick(event: Event)
        fun onMoreInfoClick(event: Event)
        fun onCloseInfoClick()
        fun categoryChosen(category: Category)
    }
}