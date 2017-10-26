package com.github.team_apple.gencon.di

import com.github.team_apple.gencon.GenConApplication
import com.github.team_apple.gencon.data.DetaModule
import com.github.team_apple.gencon.domain.DomainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class,DetaModule::class,DomainModule::class))
interface AppComponent : UseCaseComponent {
    fun inject(application: GenConApplication)
}
