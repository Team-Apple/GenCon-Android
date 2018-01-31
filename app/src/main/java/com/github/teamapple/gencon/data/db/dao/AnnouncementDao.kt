package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.*
import com.github.teamapple.gencon.data.db.entity.AnnouncementEntity
import io.reactivex.Flowable

@Dao
abstract class AnnouncementDao {

    @Query("SELECT * from announcement")
    abstract fun getAllAnnouncements(): Flowable<List<AnnouncementEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(announcements: List<AnnouncementEntity>)

    @Query("DELETE FROM announcement")
    abstract fun deleteAll()

    @Transaction
    open fun clearAndInsert(announcements: List<AnnouncementEntity>){
        deleteAll()
        insert(announcements)
    }
}
