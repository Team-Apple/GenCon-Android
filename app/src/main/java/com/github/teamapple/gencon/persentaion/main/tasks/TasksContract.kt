package com.github.teamapple.gencon.persentaion.main.tasks

import com.github.teamapple.gencon.model.TaskModel

interface TasksContract {
    interface Presenter {
        fun onResume(view: View)
        fun onPause()
        //fun loadDaysTasks(date: DateModel)
    }

    interface View {
        fun updateEvents(events: List<TaskModel>)
        fun setLoadingIndicator(active: Boolean)
        fun setNoEventsView(shown: Boolean)
        fun showMessage(message: String)
    }
}
