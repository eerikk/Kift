package uk.co.envoplan.habitaction.api

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.kift.storage.api.BaseResponse
import io.reactivex.Single
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

/**
 * Created by kaspar on 23/08/2017.
 */
class ResponseConverter(private val gson: Gson) {

    fun <S, E> convert(response: Single<Response<S>>, errorType: Type) =
            response.toResponse<S, E>(errorType)

    private fun <S, E> Single<Response<S>>.toResponse(errorType: Type) =
            map { getResponse<S, E>(it, errorType) }.catchExpectedErrors()

    private fun <S, E> getResponse(it: Response<S>, errorType: Type): BaseResponse<S, E> {
        return if (it.isSuccessful) it.asSuccess()
        else it.asError(errorType)
    }

    private fun<E> getError(json: String, errorType: Type) = gson.fromJson<E>(json, errorType)

    private fun <S, E> Single<BaseResponse<S, E>>.catchExpectedErrors(): Single<BaseResponse<S, E>> {
        return this.onErrorReturn {
            if (it is HttpException || it is IOException || it is JsonParseException)
                it.asErrorResult()
            else
                throw it
        }
    }

    private fun <S, E> Response<S>.asSuccess()
            = BaseResponse.Success<S, E>(body())

    private fun <S, E> Response<S>.asError(errorType: Type)
            = BaseResponse.Error<S, E>(getError(errorBody().string(), errorType))

    private fun <S, E> Throwable.asErrorResult()
            = BaseResponse.Failed<S, E>(this)
}