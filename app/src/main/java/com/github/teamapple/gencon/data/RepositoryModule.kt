package com.github.teamapple.gencon.data

import com.github.teamapple.gencon.data.repository.EventsRepositoryImpl
import com.github.teamapple.gencon.data.repository.EventsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsEventsRepository(repository:EventsRepositoryImpl): EventsRepository
}
