package com.kift.kift.events

import com.kift.storage.api.BaseResponse
import com.kift.storage.api.EventsResponseError
import com.kift.storage.api.EventsResponseSuccess
import com.kift.storage.api.EventsService
import com.kift.storage.models.Category
import com.kift.storage.models.Event
import com.kift.storage.storage.EventsStorage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Eerik on 01/10/17.
 */
class EventsPresenter(eventsService: EventsService,
                      val eventsStorage: EventsStorage) : EventsContract.Presenter() {

    init {
        eventsService.getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response -> onSuccess(response) }
    }

    private fun onSuccess(response: BaseResponse<EventsResponseSuccess, EventsResponseError>) {
        when (response) {
            is BaseResponse.Success -> handleSuccessData(response.data)
            is BaseResponse.Error -> println("error")
            is BaseResponse.Failed -> println("failed")
        }
    }

    private fun handleSuccessData(data: EventsResponseSuccess) {

    }


    override fun onMapClick() {
        onView { it.openMapActivity() }
    }

    override fun onEventClick(event: Event) {
        onView { it.openEventActivity(event) }
    }

    override fun onCategoryClick(category: Category) {

    }

}