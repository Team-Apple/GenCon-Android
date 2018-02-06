package com.github.teamapple.gencon.persentaion.main

import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.di.scopes.ActivityScope
import com.github.teamapple.gencon.persentaion.main.events.EventsFragmentModule
import com.github.teamapple.gencon.persentaion.main.events.EventsViewModelModule
import com.github.teamapple.gencon.persentaion.main.tasks.TasksFragmentModule
import com.github.teamapple.gencon.persentaion.main.tasks.TasksViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModuleBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        TasksFragmentModule::class,
        TasksViewModelModule::class,
        EventsFragmentModule::class,
        EventsViewModelModule::class

    ])
    fun contributeMainActivity(): MainActivity
}


@Module
interface MainActivityModule {
    @Binds
    fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity


}

