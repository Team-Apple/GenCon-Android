package com.github.teamapple.gencon.persentaion.main.tasks

import com.github.teamapple.gencon.di.modules.ViewModelModule
import com.github.teamapple.gencon.di.scopes.ActivityScope
import com.github.teamapple.gencon.di.scopes.FragmentScope
import dagger.Module

@Module
interface TasksFragmentModule {

    @FragmentScope
    fun contributeTaskFragment(): TasksFragmentModule
}

@Module
@ActivityScope
class TasksViewModelModule: ViewModelModule<TasksViewModel>(TasksViewModel::class.java)
