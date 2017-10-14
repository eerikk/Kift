package com.kift.storage.api

import io.reactivex.Single

/**
 * Created by Eerik on 14/10/17.
 */
interface EventsService{

    fun getEvents() :
            Single<BaseResponse<EventsResponseSuccess, EventsResponseError>>
}