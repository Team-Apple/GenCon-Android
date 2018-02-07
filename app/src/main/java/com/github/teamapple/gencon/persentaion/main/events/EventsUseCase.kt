package com.github.teamapple.gencon.persentaion.main.events

import android.arch.lifecycle.LiveData
import com.github.teamapple.gencon.domain.repository.EventRepository
import com.github.teamapple.gencon.domain.model.EventModel
import javax.inject.Inject

class EventsUseCase @Inject constructor(
        private val repository: EventRepository
) {

    fun getAllEventOfDay(date: String): LiveData<List<EventModel>>{
        CachePolicy.Default
        TODO()
    }

}
