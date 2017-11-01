package com.github.teamapple.gencon.presentation.ui.main.events

import android.content.Intent
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    override fun loadTodayEvent() {
        view.setLoadingIndicator(true)
        compositeDisposable += useCase.getTodayEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnDispose { view.setLoadingIndicator(false) }
                .subscribe(
                        { events ->
                            Timber.d(events.toString())
                            view.updateEvents(events)
                            view.setLoadingIndicator(false)

                        },
                        {
                            view.setLoadingIndicator(false)
                        }
                )
    }
}
