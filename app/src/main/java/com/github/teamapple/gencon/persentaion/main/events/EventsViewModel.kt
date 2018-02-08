package com.github.teamapple.gencon.persentaion.main.events

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.github.teamapple.gencon.data.repository.EventRepository
import com.github.teamapple.gencon.model.EventModel
import com.github.teamapple.gencon.util.DateFormatter
import com.github.teamapple.gencon.util.ext.toLiveData
import org.threeten.bp.LocalDate
import javax.inject.Inject

class EventsViewModel @Inject constructor(private val repository: EventRepository) : ViewModel() {

    val events: LiveData<List<EventModel>>
        get() = repository.getEvents(DateFormatter.format(LocalDate.now())).toLiveData()

}
