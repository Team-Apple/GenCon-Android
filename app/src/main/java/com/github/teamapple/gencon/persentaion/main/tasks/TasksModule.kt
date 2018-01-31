package com.github.teamapple.gencon.persentaion.main.tasks

import com.github.teamapple.gencon.di.scopes.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class TasksModule {
    @Binds
    @FragmentScope
    abstract fun bindsEventPresenter(presenter: TasksPresenter): TasksContract.Presenter
}
