package com.example.recipetesttask.domain.model

data class Recipe(
    val calories: String,
    val carbos: String,
    val country: String,
    val description: String,
    val fats: String,
    val id: String,
    val image: String,
    val name: String,
    val proteins: String,
    val time: String
)
