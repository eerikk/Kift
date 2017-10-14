package com.kift.storage.api

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.kift.storage.helpers.mocks.ERROR_CODE
import com.kift.storage.helpers.mocks.MEDIA_TYPE
import com.kift.storage.helpers.mocks.SUCCESS_CODE
import io.reactivex.Single
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response
import uk.co.envoplan.habitaction.api.ResponseConverter
import java.io.IOException

/**
 * Created by Eerik on 14/10/17.
 */
class ResponseConverterTest {

    private val gson = Gson()
    private val converter = ResponseConverter(gson)


    private val type = String::class.java
    private val success = Single.just(Response.success(SUCCESS_CODE))
    private val error = Single.just(
            Response.error<Int>(401, ResponseBody.create(MEDIA_TYPE, ERROR_CODE)))

    private val httpException = Single.error<Response<Int>>(HttpException(Response.success(13)))
    private val ioException = Single.error<Response<Int>>(IOException())
    private val runtimeException = Single.error<Response<Int>>(RuntimeException())
    private val jsonParseException = Single.error<Response<Int>>(JsonParseException(""))

    @Test
    fun convert_success() {
        val result = getResult(success)
        assertTrue(result is BaseResponse.Success)
        assertEquals(SUCCESS_CODE, (result as BaseResponse.Success).data)
    }

    @Test
    fun convert_error() {
        val result = getResult(error)
        assertTrue(result is BaseResponse.Error)
        assertEquals(ERROR_CODE, (result as BaseResponse.Error).data)
    }

    @Test
    fun convert_httpException() {
        val result = getResult(httpException)
        assertTrue(result is BaseResponse.Failed)
    }

    @Test
    fun convert_ioException() {
        val result = getResult(ioException)
        assertTrue(result is BaseResponse.Failed)
    }

    @Test(expected = RuntimeException::class)
    fun convert_runtimeException() {
        getResult(runtimeException)
    }

    @Test
    fun convert_jsonParseException() {
        val result = getResult(jsonParseException)
        assertTrue(result is BaseResponse.Failed)
    }

    private fun getResult(single: Single<Response<Int>>): BaseResponse<Int, String> =
            converter.convert<Int, String>(single, type).blockingGet()

}