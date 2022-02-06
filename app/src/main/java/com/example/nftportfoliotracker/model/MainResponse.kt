package com.example.nftportfoliotracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = MainResponse.TABLE_NAME)
data class MainResponse(
    @PrimaryKey(autoGenerate = true)
    val primaryId: Int,
    @field:SerializedName("cards")
    val cards: List<MainResponse>?){
    companion object {
        const val TABLE_NAME = "main"
    }
}