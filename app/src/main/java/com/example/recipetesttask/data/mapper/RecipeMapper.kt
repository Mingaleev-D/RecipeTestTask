package com.example.recipetesttask.data.mapper

import com.example.recipetesttask.data.local.RecipeEntity
import com.example.recipetesttask.data.remote.model.RecipeDto
import com.example.recipetesttask.domain.model.Recipe

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

fun RecipeDto.mapToDomain(): Recipe {
   return Recipe(
       calories = this.calories ?: "",
       carbos = this.carbos ?: "",
       country = this.country?: "",
       description = this.description ?: "",
       fats = this.fats ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
       proteins = this.proteins ?: "",
       time = this.time ?: ""

   )
}

fun RecipeDto.mapToEntity(): RecipeEntity {
   return RecipeEntity(
       calories = this.calories ?: "",
       carbos = this.carbos ?: "",
       country = this.country?: "",
       description = this.description ?: "",
       fats = this.fats ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
       proteins = this.proteins ?: "",
       time = this.time ?: ""

   )
}
fun RecipeEntity.mapToDomain(): Recipe {
   return Recipe(
       calories = this.calories ?: "",
       carbos = this.carbos ?: "",
       country = this.country?: "",
       description = this.description ?: "",
       fats = this.fats ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
       proteins = this.proteins ?: "",
       time = this.time ?: ""

   )
}

fun Recipe.mapToEntity(): RecipeEntity {
   return RecipeEntity(
       calories = this.calories ?: "",
       carbos = this.carbos ?: "",
       country = this.country?: "",
       description = this.description ?: "",
       fats = this.fats ?: "",
       id = this.id ?: "",
       image = this.image ?: "",
       name = this.name ?: "",
       proteins = this.proteins ?: "",
       time = this.time ?: ""

   )
}