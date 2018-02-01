package com.github.teamapple.gencon.persentaion.main.events

import com.github.teamapple.gencon.model.EventModel

interface EventsContract {
    interface Presenter {
        fun onResume(view: View)
        fun onPause()
    }

    interface View {
        fun updateEvents(events: List<EventModel>)
        fun setLoadingIndicator(active: Boolean)
        fun setNoEventsView(shown: Boolean)
        fun showMessage(message: String)
    }

}
