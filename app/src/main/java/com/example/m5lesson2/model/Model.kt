package com.example.m5lesson2.model

import com.google.gson.annotations.SerializedName

data class Info(
        val count: Int,
        val pages: Int,
        val next: String?,
        val prev: String?
    )

data class Character(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: Location,
    @SerializedName("location") val location: Location,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String
)

data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
