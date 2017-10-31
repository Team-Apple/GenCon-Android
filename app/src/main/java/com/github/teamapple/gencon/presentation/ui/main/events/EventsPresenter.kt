package com.github.teamapple.gencon.presentation.ui.main.events

import android.content.Intent
import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.usecase.EventsUseCase
import com.github.teamapple.gencon.extension.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


class EventsPresenter @Inject constructor(val useCase: EventsUseCase) : EventsContract.Presenter {
    lateinit var view: EventsContract.View
    val compositeDisposable = CompositeDisposable()
    override fun onResume(view: EventsContract.View) {
        this.view = view
    }
    override fun onPause() {
        compositeDisposable.clear()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    override fun loadTodayEvent() {
        compositeDisposable += useCase.getDailyEvents(DateModel(year = 2017,month = 10,day = 12))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { events->
                            Timber.d(events.toString())
                            view.updateEvents(events)
                        },
                        {
                            view.showMessage(it.message.toString())
                        }
                )
    }
}
