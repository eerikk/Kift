package com.kift.storage

import android.content.Context
import com.kift.storage.helpers.any
import com.kift.storage.helpers.anyObject
import com.kift.storage.helpers.mock
import com.kift.storage.helpers.whenever
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by Eerik on 23/10/17.
 */
class StorageProviderTest {

    @Test
    fun test() {
        val context = mock<Context>()
        whenever(context.getSharedPreferences(anyObject(), any())).thenReturn(mock())

        val provider = StorageProvider(context)

        assertNotNull(provider.eventRepo)
    }
}