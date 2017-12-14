package com.github.teamapple.gencon.ui.main.events

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.usecase.EventsUseCase
import com.github.teamapple.gencon.extension.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


class EventsPresenter @Inject constructor(private val useCase: EventsUseCase) : EventsContract.Presenter {
    private lateinit var view: EventsContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun onResume(view: EventsContract.View) {
        this.view = view
    }

    override fun onPause() {
        compositeDisposable.clear()
    }

    override fun loadDaysEvents(date: DateModel) {
        view.setLoadingIndicator(true)
        compositeDisposable += useCase.getEventsOfDay(date)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnDispose { view.setLoadingIndicator(false) }
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
