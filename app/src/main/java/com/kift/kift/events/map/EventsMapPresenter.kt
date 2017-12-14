package com.kift.kift.events.map

import com.kift.storage.models.Category
import com.kift.storage.models.Event
import com.kift.storage.repository.EventRepo

/**
 * Created by Eerik on 04/12/17.
 */
class EventsMapPresenter(eventRepo: EventRepo)
    : EventsMapContract.Presenter {

    lateinit var view: EventsMapContract.View

    override fun onMoreInfoClick(event: Event) {
        view.openEventActivity(event)
    }

    override fun onCloseInfoClick() {
//        view.showState(EventsMapState(
//                isLoading = false,
//                category = category,
//        )
//        )
    }

    override fun categoryChosen(category: Category) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMarkerClick(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}