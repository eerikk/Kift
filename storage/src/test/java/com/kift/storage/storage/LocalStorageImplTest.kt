package com.kift.storage.storage

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.google.gson.Gson
import com.kift.storage.helpers.*
import com.kift.storage.helpers.mocks.EVENTS_JSON
import com.kift.storage.helpers.mocks.EVENTS_JSON_EMPTY
import com.kift.storage.helpers.mocks.EVENT_KIFT
import com.kift.storage.models.Event
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Eerik on 01/10/17.
 */
@SuppressLint("CommitPrefEdits")
class LocalStorageImplTest {

    private val events = listOf(EVENT_KIFT)

    private val gson = Gson()

    lateinit var editor: SharedPreferences.Editor
    lateinit var sharedPrefs: SharedPreferences
    private lateinit var storage: LocalStorageImpl

    @Before
    fun setUp() {
        editor = mock()
        setupEditor()
        setupSharedPrefs()
        storage = LocalStorageImpl(sharedPrefs, gson)
    }

    private fun setupSharedPrefs() {
        sharedPrefs = mock()
        whenever(sharedPrefs.edit()).thenReturn(editor)
    }

    private fun setupEditor() {
        whenever(editor.putString(Mockito.any(), Mockito.any())).thenReturn(editor)
    }

    private fun setEditorResponse(response: String) {
        val arg = Event::class.java.simpleName
        whenever(sharedPrefs.getString(Mockito.eq(arg), any())).thenReturn(response)
    }

    @Test
    fun saveList() {
        storage.saveList(events, Event::class.java)
        verify(sharedPrefs).edit()
        verify(editor).putString(Event::class.java.simpleName, gson.toJson(events))
        verify(editor).apply()
    }

    @Test
    fun loadList_returnsList() {
        setEditorResponse(EVENTS_JSON)
        assertListEquals(events, storage.loadList(Event::class.java))
    }

    @Test
    fun loadList_handlesEmptyList() {
        setEditorResponse(EVENTS_JSON_EMPTY)
        assertEquals(listOf<Event>(), storage.loadList(Event::class.java))
    }

    @Test
    fun loadList_handlesEmptyError() {
        setEditorResponse("")
        assertEquals(listOf<Event>(), storage.loadList(Event::class.java))
    }

    @Test
    fun loadList_handlesRandomResponse() {
        setEditorResponse("bugiwugi")
        assertEquals(listOf<Event>(), storage.loadList(Event::class.java))
    }


}