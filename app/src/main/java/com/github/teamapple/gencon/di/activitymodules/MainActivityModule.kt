package com.github.teamapple.gencon.di.activitymodules

import com.github.teamapple.gencon.di.scopes.FragmentScope
import com.github.teamapple.gencon.persentaion.main.task.TaskFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    /*@Binds
    @IntoMap
    @ViewModelKey(TaskViewModel::class)
    fun bindMainStore(viewModel: TaskViewModel): ViewModel*/


    @ContributesAndroidInjector
    @FragmentScope
    fun contributeTaskFragment(): TaskFragment


}
