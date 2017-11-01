package com.github.teamapple.gencon.presentation.ui.main.events

import android.content.Context
import android.content.Intent
import com.github.teamapple.gencon.domain.model.EventModel

interface EventsContract {
    interface Presenter {
        fun onResume(view: View)
        fun onPause()
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
        fun loadTodayEvent()
    }

    interface View {
        fun updateEvents(events: List<EventModel>)
        fun setLoadingIndicator(active: Boolean)
        fun showNoEvents()
        fun showMessage(message: String)
    }

    interface Navigator{
        fun navigateToEventEdit(context: Context)
    }
}
