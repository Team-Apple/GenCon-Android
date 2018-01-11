package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.GenConApplication
import com.github.teamapple.gencon.data.DataModule
import com.github.teamapple.gencon.data.network.ApiClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent : UseCaseComponent {
    fun inject(application: GenConApplication)

    fun apiclient():ApiClient
}
