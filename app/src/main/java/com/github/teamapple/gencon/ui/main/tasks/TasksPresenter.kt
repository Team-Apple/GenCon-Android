package com.github.teamapple.gencon.ui.main.tasks

import com.github.teamapple.gencon.domain.usecase.EventsUseCase
import com.github.teamapple.gencon.extension.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


class TasksPresenter @Inject constructor(private val useCase: EventsUseCase) : TasksContract.Presenter {
    private lateinit var view: TasksContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun onResume(view: TasksContract.View) {
        this.view = view
    }

    override fun onPause() {
        compositeDisposable.clear()
    }

    override fun loadTodayEvent() {
        view.setLoadingIndicator(true)
        compositeDisposable += useCase.getTodayEvents()
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
