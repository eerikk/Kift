package com.kift.kift.events

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * Created by Eerik on 21/10/17.
 */
val PAGE_LIST = 0
val PAGE_MAP = 1

class ViewPagerAdapter(private val views: List<ViewGroup>) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        container?.addView(views[position])

        println("Instatinating item @pos $position")

        return views[position]
    }

    fun getItem(position: Int): ViewGroup = views[position]

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        view?.let { return view == `object` }
        return false
    }

    override fun getCount(): Int = views.size

    override fun getPageTitle(position: Int): CharSequence = "TEST"
}