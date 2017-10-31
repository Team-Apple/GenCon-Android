package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.GenConApplication
import com.github.teamapple.gencon.data.DetaModule
import com.github.teamapple.gencon.domain.DomainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class,DetaModule::class,DomainModule::class))
interface AppComponent : UseCaseComponent {
    fun inject(application: GenConApplication)
}
