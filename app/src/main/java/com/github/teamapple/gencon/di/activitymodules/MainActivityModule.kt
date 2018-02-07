package com.github.teamapple.gencon.di.activitymodules

import android.arch.lifecycle.ViewModel
import com.github.teamapple.gencon.di.ViewModelKey
import com.github.teamapple.gencon.di.scopes.FragmentScope
import com.github.teamapple.gencon.persentaion.main.task.TaskFragment
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
    fun bindMainStore(viewModel: TasksViewModel): ViewModel


    @ContributesAndroidInjector
    @FragmentScope
    fun contributeTaskFragment(): TaskFragment


}
