package com.example.nftportfoliotracker.db

import android.content.Context
import androidx.room.Room
import com.example.nftportfoliotracker.db.dao.MainModelDao


class AppDatabaseProvider(val context: Context) {

    var db: AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "appdatabase.db")
        .fallbackToDestructiveMigration()
        .build()

    fun getMainModelDao(): MainModelDao {
        return db.mainModelDao()
    }

}