package com.github.team_apple.gencon.domain

import com.github.team_apple.gencon.domain.usecase.EventsUseCase
import com.github.team_apple.gencon.domain.usecase.EventsUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DomainModule{

    @Binds
    @Singleton
    abstract fun bindsEventsUsecase(impl:EventsUseCaseImpl): EventsUseCase
}
