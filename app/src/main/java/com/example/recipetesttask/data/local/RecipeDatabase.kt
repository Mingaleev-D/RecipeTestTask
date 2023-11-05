package com.example.recipetesttask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

@Database(entities = [RecipeEntity::class], version = 1)
abstract class RecipeDatabase:RoomDatabase() {
   abstract fun recipeDao(): RecipeDao
}