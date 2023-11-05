package com.example.recipetesttask.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeEntity(
    val calories: String,
    val carbos: String,
    val country: String,
    val description: String,
    val fats: String,
    @PrimaryKey
    val id: String,
    val image: String,
    val name: String,
    val proteins: String,
    val time: String
)

