package com.kift.kift.events

import android.os.Bundle
import com.kasparpeterson.simplemvp.MVPBaseActivity
import com.kift.kift.R
import com.kift.storage.models.Category
import com.kift.storage.models.Event
import kotlinx.android.synthetic.main.activity_events.*

class EventsActivity : MVPBaseActivity<EventsContract.Presenter, EventsContract.View>(),
        EventsContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
    }

    override fun getView(): EventsContract.View = this

    override fun createPresenter()
            : EventsContract.Presenter
            = EventsPresenter()

    override fun showCategory(category: Category) {
        events_view.showCategory(category)
    }

    override fun showError(errorMsg: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openEventActivity(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
