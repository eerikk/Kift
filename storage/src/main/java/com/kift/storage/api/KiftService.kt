package com.kift.storage.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Eerik on 14/10/17.
 */

interface KiftService {

    @GET("events")
    fun getEvents(): Single<Response<EventsResponseSuccess>>
}