package com.github.teamapple.gencon.persentaion.main.events

import com.github.teamapple.gencon.di.modules.ViewModelModule
import com.github.teamapple.gencon.di.scopes.ActivityScope
import com.github.teamapple.gencon.di.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface EventsFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeEventsFragment(): EventsFragment
}

@Module
@ActivityScope
class EventsViewModelModule: ViewModelModule<EventsViewModel>(EventsViewModel::class.java)
