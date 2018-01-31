package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.github.teamapple.gencon.data.db.entity.AnnouncementEntity
import io.reactivex.Flowable

@Dao
abstract class AnnouncementDao {

    @Query("SELECT * from announcement")
    abstract fun getAllAnnouncements(): Flowable<List<AnnouncementEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(announcements: List<AnnouncementEntity>)
}
