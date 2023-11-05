package com.example.recipetesttask.data.remote.model


import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("calories")
    val calories: String = "",
    @SerializedName("carbos")
    val carbos: String = "",
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("fats")
    val fats: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("proteins")
    val proteins: String = "",
    @SerializedName("time")
    val time: String = ""
)