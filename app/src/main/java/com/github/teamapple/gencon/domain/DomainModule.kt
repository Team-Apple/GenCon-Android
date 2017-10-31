package com.github.teamapple.gencon.domain

import com.github.teamapple.gencon.domain.usecase.EventsUseCase
import com.github.teamapple.gencon.domain.usecase.EventsUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DomainModule{

    @Binds
    @Singleton
    abstract fun bindsEventsUsecase(impl:EventsUseCaseImpl): EventsUseCase
}
