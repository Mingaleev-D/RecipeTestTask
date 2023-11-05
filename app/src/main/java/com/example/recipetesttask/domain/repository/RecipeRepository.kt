package com.example.recipetesttask.domain.repository

import com.example.recipetesttask.domain.model.Recipe

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

interface RecipeRepository {

   suspend fun fetchRecipeList(): List<Recipe>
   suspend fun insertRecipeList(recipeList: List<Recipe>)
   suspend fun getRecipeList(): List<Recipe>

   suspend fun insertAddRecipe(recipe: Recipe)
}