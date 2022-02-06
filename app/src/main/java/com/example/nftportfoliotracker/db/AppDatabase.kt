package com.example.nftportfoliotracker.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nftportfoliotracker.db.dao.MainModelDao
import com.example.nftportfoliotracker.model.MainResponse

@Database(
    entities = [MainResponse::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mainModelDao(): MainModelDao

}