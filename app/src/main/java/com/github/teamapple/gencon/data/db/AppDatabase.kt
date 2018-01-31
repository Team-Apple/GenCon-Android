package com.github.teamapple.gencon.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(
        entities = emptyArray(),
        version = 1
)
abstract class AppDatabase: RoomDatabase(){

}
