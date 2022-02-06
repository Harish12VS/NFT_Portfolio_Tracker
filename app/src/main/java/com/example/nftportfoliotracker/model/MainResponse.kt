package com.example.nftportfoliotracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MainResponse(
    val primaryId: Int,
    val nfts: List<Nft>,
    val response: String,
    val total:Int
)

data class Nft(
    val cached_file_url: String,
    val contract_address: String,
    val creator_address: String,
    val description: String,
    val file_url: String,
    val metadata: Metadata,
    val metadata_url: String,
    val name: String,
    val token_id: String
)

data class Metadata(
    val description: String,
    val external_url: String,
    val image: String,
    val name: String,
    val properties: List<Property>,
    val sandbox: Sandbox
)

data class Property(
    val display_type: String,
    val max_value: Int,
    val trait_type: String,
    val value: Int
)

data class Sandbox(
    val description: String,
    val name: String
)
