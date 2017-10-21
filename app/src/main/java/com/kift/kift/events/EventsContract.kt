package com.kift.kift.events

import com.kasparpeterson.simplemvp.MVPBasePresenter
import com.kasparpeterson.simplemvp.MVPBaseView
import com.kift.storage.models.Category
import com.kift.storage.models.Event

/**
 * Created by Eerik on 23/09/17.
 */
interface EventsContract {

    interface View : MVPBaseView {
        fun showState(state: EventsState)
        fun openEventActivity(event: Event)
        fun openMapActivity()
    }

    abstract class Presenter : MVPBasePresenter<View>() {
        abstract fun onEventClick(event: Event)
        abstract fun onCategoryClick(category: Category)
        abstract fun onMapClick()
    }
}