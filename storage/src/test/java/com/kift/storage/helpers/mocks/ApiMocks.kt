package com.kift.storage.helpers.mocks

import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Created by Eerik on 14/10/17.
 */
val SUCCESS_CODE = 69
val ERROR_CODE = "777"
val MEDIA_TYPE = MediaType.parse("application/json")
val EVENTS_ERROR_JSON = "{\"status\":0, \"message\":\"server error\"}"

fun getEventsErrorBody() = ResponseBody.create(MEDIA_TYPE, EVENTS_ERROR_JSON)
fun getEventsErrorResposne() = Response.error<String>(420, getEventsErrorBody())