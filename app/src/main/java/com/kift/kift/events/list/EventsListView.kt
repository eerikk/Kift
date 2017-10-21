package com.kift.kift.events.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.kift.kift.R

/**
 * Created by Eerik on 21/10/17.
 */
@SuppressLint("ViewConstructor")
class EventsListView(context: Context, screenNr: Int) :
        LinearLayout(context), EventsListContract.View {

    private val presenter: EventsListPresenter

    init {
        println("Init EVENTS LIST INITIALIZED $screenNr")
        View.inflate(context, R.layout.view_events_list, this)
        presenter = EventsListPresenter(this)
    }

    override fun showState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}