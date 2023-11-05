package com.example.recipetesttask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

@Dao
interface RecipeDao {

   @Query("SELECT * FROM RecipeEntity")
   suspend fun getAllRecipe(): List<RecipeEntity>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAllRecipe(vararg recipe: RecipeEntity)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAddRecipe(recipe: RecipeEntity)
}