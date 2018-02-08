package com.github.teamapple.gencon.di.activitymodules

import android.arch.lifecycle.ViewModel
import com.github.teamapple.gencon.di.ViewModelKey
import com.github.teamapple.gencon.di.scopes.FragmentScope
import com.github.teamapple.gencon.persentaion.main.announcement.AnnouncementsFragment
import com.github.teamapple.gencon.persentaion.main.announcement.AnnouncementsViewModel
import com.github.teamapple.gencon.persentaion.main.events.EventsFragment
import com.github.teamapple.gencon.persentaion.main.events.EventsViewModel
import com.github.teamapple.gencon.persentaion.main.task.TasksFragment
import com.github.teamapple.gencon.persentaion.main.task.TasksViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(TasksViewModel::class)
    fun bindTasksViewModel(viewModel: TasksViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventsViewModel::class)
    fun bindEventsViewModel(viewModel: EventsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnnouncementsViewModel::class)
    fun bindAnnouncementsViewModel(viewModel: AnnouncementsViewModel): ViewModel


    @ContributesAndroidInjector
    @FragmentScope
    fun contributeTasksFragment(): TasksFragment

    @ContributesAndroidInjector
    @FragmentScope
    fun contributeEventsFragment(): EventsFragment

    @ContributesAndroidInjector
    @FragmentScope
    fun contributeAnnouncementFragment(): AnnouncementsFragment


}
