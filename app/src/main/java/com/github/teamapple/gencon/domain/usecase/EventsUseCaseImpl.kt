package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.repository.EventsRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsUseCaseImpl @Inject constructor(private val repository: EventsRepository) : EventsUseCase {

    override fun getDailyEvents(date: DateModel): Single<List<EventModel>> {
        return repository.fetchDailyEvents(date)
                .subscribeOn(Schedulers.io())
                .map { it.map { EventModel.convert(it) } }
    }
}
