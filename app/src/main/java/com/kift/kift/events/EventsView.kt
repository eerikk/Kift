package com.kift.kift.events

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.widget.FrameLayout
import com.kift.kift.App
import com.kift.kift.R
import com.kift.kift.events.list.EventsListView
import com.kift.kift.events.list.EventsMapView
import com.kift.storage.models.Category
import kotlinx.android.synthetic.main.view_events.view.*

/**
 * Created by Eerik on 30/11/17.
 */
class EventsView : FrameLayout, ViewPager.OnPageChangeListener {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int)
            : super(context, attrs, defStyle) {
        init(attrs)
    }

    private lateinit var eventsListView: EventsListView
    private lateinit var eventsMapView: EventsMapView


    private fun init(attrs: AttributeSet? = null) {
        inflate(context, R.layout.view_events, this)
        initViews()
        setupViewPager()
    }

    private fun initViews() {
        eventsListView = EventsListView(context, App.storageProvider.eventRepo)
        eventsMapView = EventsMapView(context, App.storageProvider.eventRepo)
    }

    private fun setupViewPager() {
        events_view_pager.adapter = EventsPagerAdapter(context,
                listOf(eventsListView, eventsMapView))
        events_view_pager.addOnPageChangeListener(this)
        tab_layout.setupWithViewPager(events_view_pager)
    }

    fun showCategory(category: Category) {
        eventsListView.categoryChosen(category)
        eventsMapView.categoryChosen(category)
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        println("PAGE SELECTED $position")
    }

}