package com.github.teamapple.gencon.ui.main.events

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel

interface EventsContract {
    interface Presenter {
        fun onResume(view: View)
        fun onPause()
        fun loadDaysEvents(date: DateModel)
    }

    interface View {
        fun updateEvents(events: List<EventModel>)
        fun setLoadingIndicator(active: Boolean)
        fun setNoEventsView(shown: Boolean)
        fun showMessage(message: String)
    }

}
