package com.github.teamapple.gencon.presentation.ui.main.events

import com.github.teamapple.gencon.di.scopes.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class EventsModule {
    @Binds
    @FragmentScope
    abstract fun bindsEventPresenter(presenter: EventsPresenter):EventsContract.Presenter

    @Binds
    @FragmentScope
    abstract fun bindsEventsNavigator(navigator: EventsNavigator):EventsContract.Navigator
}
