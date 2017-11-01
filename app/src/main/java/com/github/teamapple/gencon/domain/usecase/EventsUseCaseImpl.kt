package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateFormatter
import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.repository.EventsRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber
import javax.inject.Inject


class EventsUseCaseImpl @Inject constructor(private val repository: EventsRepository) : EventsUseCase {

    private val formatter = object : DateFormatter {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val outputFormatter = DateTimeFormatter.ofPattern("MM/dd")
        override fun format(dateTime: String): String {
            val from = LocalDateTime.parse(dateTime,formatter)
            return outputFormatter.format(from)
        }
    }

    override fun getDailyEvents(date: DateModel): Single<List<EventModel>> {
        return repository.fetchDailyEvents(date)
                .subscribeOn(Schedulers.io())
                .map { it.map { EventModel.convert(it, formatter) } }
    }

    override fun getTodayEvents(): Single<List<EventModel>> {
        val today = LocalDate.now()
        return repository.fetchDailyEvents(DateModel(year = today.year, month = today.monthValue, day = 3))
                .subscribeOn(Schedulers.io())
                .map { it.map { EventModel.convert(it, formatter) } }
                .doOnSuccess { Timber.d(it.toString()) }
    }
}
