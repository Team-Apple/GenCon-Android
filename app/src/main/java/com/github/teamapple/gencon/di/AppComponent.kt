package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.GenConApplication
import com.github.teamapple.gencon.data.DataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {
    fun inject(application: GenConApplication)
}
