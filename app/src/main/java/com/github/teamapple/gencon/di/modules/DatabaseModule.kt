package com.github.teamapple.gencon.di.modules

import com.github.teamapple.gencon.data.db.*
import dagger.Binds
import dagger.Module

@Module
interface DatabaseModule {

    @Binds
     fun bindEventDatabase(database: EventRoomDatabase): EventDatabase

    @Binds
     fun bindTaskDatabase(database: TaskRoomDatabase): TaskDatabase

    @Binds
     fun bindAnnouncementDatabase(database: AnnouncementRoomDatabase): AnnouncementDatabase

}
