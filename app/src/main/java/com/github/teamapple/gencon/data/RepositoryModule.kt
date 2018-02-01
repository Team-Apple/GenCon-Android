package com.github.teamapple.gencon.data

import com.github.teamapple.gencon.data.repository.EventRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsEventsRepository(repository:EventsRepositoryImpl): EventRepository
}
