package com.kift.storage.api

import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by Eerik on 14/10/17.
 */
class ApiClientTest{

    @Test
    fun test(){
        val client = ApiClient()
        assertNotNull(client.service)

    }
}