package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.repository.EventsRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDate
import javax.inject.Inject


class EventsUseCaseImpl @Inject constructor(private val repository: EventsRepository) : EventsUseCase {

    override fun getDailyEvents(date: DateModel): Single<List<EventModel>> {
        return repository.fetchDailyEvents(date)
                .subscribeOn(Schedulers.io())
                .map { it.map { EventModel.convert(it) } }
    }

    override fun getTodayEvents(): Single<List<EventModel>> {
        val today = LocalDate.now()
        return repository.fetchDailyEvents(DateModel(year = today.year, month = today.monthValue ,day = today.dayOfMonth))
                .subscribeOn(Schedulers.io())
                .map { it.map { EventModel.convert(it) } }
    }
}
