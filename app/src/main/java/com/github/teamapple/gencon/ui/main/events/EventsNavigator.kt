package com.github.teamapple.gencon.ui.main.events

import android.content.Context
import com.github.teamapple.gencon.ui.eventEdit.EventEditActivity
import javax.inject.Inject

class EventsNavigator @Inject constructor() : EventsContract.Navigator {

    override fun navigateToEventEdit(context: Context) {
        EventEditActivity.start(context)
    }
}
