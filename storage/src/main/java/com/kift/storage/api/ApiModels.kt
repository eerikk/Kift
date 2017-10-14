package com.kift.storage.api

import com.kift.storage.models.Event
import java.util.*

/**
 * Created by Eerik on 14/10/17.
 */

sealed class BaseResponse<out S, out E> {
    data class Success<out S, out E>(val data: S) : BaseResponse<S, E>()
    data class Error<out S, out E>(val data: E) : BaseResponse<S, E>()
    data class Failed<out S, out E>(val throwable: Throwable) : BaseResponse<S, E>()
}

data class EventsResponseSuccess(
        val status: Status,
        val data: List<Event>,
        val lastUpdated: Date
)

data class EventsResponseError(
        val status: Status,
        val message: String
)

enum class Status(val id: Int) {
    SUCCESS(1),
    ERROR(0)
}