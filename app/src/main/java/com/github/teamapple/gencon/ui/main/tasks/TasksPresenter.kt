package com.github.teamapple.gencon.ui.main.tasks

import com.github.teamapple.gencon.domain.model.DateModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class TasksPresenter @Inject constructor() : TasksContract.Presenter {
    private lateinit var view: TasksContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun onResume(view: TasksContract.View) {
        this.view = view
    }

    override fun onPause() {
        compositeDisposable.clear()
    }

    override fun loadDaysTasks(date: DateModel) {
        view.setLoadingIndicator(true)
        /*compositeDisposable += useCase.getEvents(date)
                .observeOn(AndroidSchedulers.mainThread())
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
