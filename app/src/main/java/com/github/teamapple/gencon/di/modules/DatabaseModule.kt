package com.github.teamapple.gencon.di.modules

import com.github.teamapple.gencon.data.db.*
import dagger.Binds
import dagger.Module

@Module
interface DatabaseModule {

    @Binds
     fun bindEventDatabase(database: EventDatabaseImpl): EventDatabase

    @Binds
     fun bindTaskDatabase(database: TaskDatabaseImpl): TaskDatabase

    @Binds
     fun bindAnnouncementDatabase(database: AnnouncementDatabaseImpl): AnnouncementDatabase

}
