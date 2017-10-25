package com.github.team_apple.gencon.di

import com.github.team_apple.gencon.GenConApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: GenConApplication)
}
