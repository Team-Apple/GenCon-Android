package com.github.teamapple.gencon.ui.main.events

import com.github.teamapple.gencon.data.repository.EventsRepository
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.extension.plusAssign
import com.github.teamapple.gencon.util.DateFormatter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber
import javax.inject.Inject


class EventsPresenter @Inject constructor(private val repository: EventsRepository) : EventsContract.Presenter {
    private lateinit var view: EventsContract.View
    private val compositeDisposable = CompositeDisposable()

    private val formatter = object : DateFormatter {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val outputFormatter = DateTimeFormatter.ofPattern("MM/dd")
        override fun format(dateTime: String): String {
            val from = LocalDateTime.parse(dateTime, formatter)
            return outputFormatter.format(from)
        }
    }

    override fun onResume(view: EventsContract.View) {
        this.view = view
        if (this.view.isEmpty()) {
            val today = LocalDate.now()
            loadDaysEvents(today.year, today.monthValue, today.dayOfMonth)
        }
    }

    override fun onPause() {
        compositeDisposable.clear()
    }

    private fun loadDaysEvents(year: Int, month: Int, day: Int) {
        view.setLoadingIndicator(true)
        compositeDisposable += repository.getEvents(year, month, day)
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.map { EventModel.convert(it, formatter) } }
                .subscribe(
                        { events ->
                            view.setNoEventsView(events.isEmpty())
                            view.updateEvents(events)
                            view.setLoadingIndicator(false)
                            Timber.d(events.toString())

                        },
                        {
                            Timber.d(it.message)
                            view.setLoadingIndicator(false)
                        }
                )
    }
}
