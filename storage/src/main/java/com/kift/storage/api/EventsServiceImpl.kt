package com.kift.storage.api

import io.reactivex.Single
import uk.co.envoplan.habitaction.api.ResponseConverter

/**
 * Created by Eerik on 14/10/17.
 */
class EventsServiceImpl(
        private val kiftService: KiftService,
        private val converter: ResponseConverter) : EventsService {


    override fun getEvents():
            Single<BaseResponse<
                    EventsResponseSuccess, EventsResponseError>> =
            converter.convert(kiftService.getEvents(), EventsResponseError::class.java)

}