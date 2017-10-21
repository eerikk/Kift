package com.kift.kift.events

import android.os.Bundle
import android.view.ViewGroup
import com.kasparpeterson.simplemvp.MVPBaseActivity
import com.kift.kift.App
import com.kift.kift.R
import com.kift.kift.events.list.EventsListView
import com.kift.storage.models.Event
import kotlinx.android.synthetic.main.activity_events.*

/**
 * Created by Eerik on 01/10/17.
 */

class EventsActivity : MVPBaseActivity<EventsContract.Presenter, EventsContract.View>(),
        EventsContract.View {

    override fun getView(): EventsContract.View = this

    override fun createPresenter(): EventsContract.Presenter {
        return EventsPresenter(App.storageProvider.eventsService,
                App.storageProvider.eventsStorage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        setupViewPager()
    }


    override fun showState(state: EventsState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openEventActivity(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMapActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setupViewPager() {
        val views = mutableListOf<ViewGroup>()
        views.add(EventsListView(this, 1))
        views.add(EventsListView(this, 2))

        val adapter = ViewPagerAdapter(views)
        view_pager.adapter = adapter
        tabs.setupWithViewPager(view_pager)
    }
}

