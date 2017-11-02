package com.github.teamapple.gencon.ui.main.tasks

import com.github.teamapple.gencon.domain.model.EventModel

interface TasksContract {
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
}
