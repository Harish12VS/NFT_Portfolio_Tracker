package com.example.nftportfoliotracker.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nftportfoliotracker.model.MainResponse

@Dao
interface MainModelDao {

    @Query("SELECT * FROM main")
    fun getAll(): LiveData<MainResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg nudge: MainResponse)

    @Query("DELETE FROM main")
    fun deleteAll()
}