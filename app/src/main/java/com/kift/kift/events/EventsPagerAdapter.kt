package com.kift.kift.events

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * Created by Eerik on 30/11/17.
 */

class EventsPagerAdapter(context: Context, private val viewsList: List<ViewGroup>)
    : PagerAdapter() {

    private val PAGE_LIST = 0
    private val PAGE_MAP = 1

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = viewsList[position]
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View?, any: Any?): Boolean = view == any

    override fun getCount(): Int = viewsList.size

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        PAGE_LIST -> "Events"
        PAGE_MAP -> "Map"
        else -> "Events"
    }
}