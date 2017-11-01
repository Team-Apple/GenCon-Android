package com.github.teamapple.gencon.presentation.ui.main.events

import android.content.Context
import com.github.teamapple.gencon.domain.model.EventModel

interface EventsContract {
    interface Presenter {
        fun onResume(view: View)
        fun onPause()
        fun loadTodayEvent()
    }

    interface View {
        fun updateEvents(events: List<EventModel>)
        fun setLoadingIndicator(active: Boolean)
        fun setNoEventsView(shown: Boolean)
        fun showMessage(message: String)
    }

    interface Navigator {
        fun navigateToEventEdit(context: Context)
    }
}
