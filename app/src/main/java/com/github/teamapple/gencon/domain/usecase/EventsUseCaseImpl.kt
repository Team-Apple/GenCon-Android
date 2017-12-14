package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.repository.EventsRepository
import com.github.teamapple.gencon.domain.util.DateFormatter
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Inject


class EventsUseCaseImpl @Inject constructor(private val repository: EventsRepository) : EventsUseCase {
    private val formatter = object : DateFormatter {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val outputFormatter = DateTimeFormatter.ofPattern("MM/dd")
        override fun format(dateTime: String): String {
            val from = LocalDateTime.parse(dateTime, formatter)
            return outputFormatter.format(from)
        }
    }

    override fun getEventsOfDay(date: DateModel): Single<List<EventModel>> {
        return repository.getEvents(date)
                .subscribeOn(Schedulers.io())
                .map { it.map { EventModel.convert(it, formatter) } }
    }

    override fun deleteEvent(eventId: Int): Completable {
        return repository.deleteEvent(eventId)
                .subscribeOn(Schedulers.io())
    }

    override fun createEvent(newEvent: EventModel): Completable {
        return repository.createEvent(newEvent)
                .subscribeOn(Schedulers.io())
    }

    override fun editEvent(eventId: Int, editedEvent: EventModel): Completable {
        return repository.editEvent(eventId, editedEvent)
                .subscribeOn(Schedulers.io())
    }


}
