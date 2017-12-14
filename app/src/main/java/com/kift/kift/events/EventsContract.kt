package com.kift.kift.events

import android.support.annotation.StringRes
import com.kasparpeterson.simplemvp.MVPBasePresenter
import com.kasparpeterson.simplemvp.MVPBaseView
import com.kift.storage.models.Category
import com.kift.storage.models.Event

interface EventsContract {

    interface View : MVPBaseView {
        fun showError(@StringRes errorMsg: Int)
        fun openEventActivity(event: Event)
        fun showCategory(category: Category)
    }

    abstract class Presenter : MVPBasePresenter<View>()
}
