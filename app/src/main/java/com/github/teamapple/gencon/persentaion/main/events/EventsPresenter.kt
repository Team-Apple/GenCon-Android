package com.github.teamapple.gencon.persentaion.main.events

import com.github.teamapple.gencon.data.repository.EventRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class EventsPresenter @Inject constructor(private val repository: EventRepository) : EventsContract.Presenter {
    private lateinit var view: EventsContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun onResume(view: EventsContract.View) {
        this.view = view
        /*if (this.view.isEmpty()) {
            val today = LocalDate.now()
            loadDaysEvents(today.year, today.monthValue, today.dayOfMonth)
        }*/
    }

    override fun onPause() {
        compositeDisposable.clear()
    }

    private fun loadDaysEvents(year: Int, month: Int, day: Int) {
        /*view.setLoadingIndicator(true)
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
                )*/
    }
}
