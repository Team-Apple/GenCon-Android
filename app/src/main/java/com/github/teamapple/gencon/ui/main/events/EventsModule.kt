package com.github.teamapple.gencon.ui.main.events

import com.github.teamapple.gencon.di.scopes.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class EventsModule {
    @Binds
    @FragmentScope
    abstract fun bindsEventPresenter(presenter: EventsPresenter):EventsContract.Presenter

}
