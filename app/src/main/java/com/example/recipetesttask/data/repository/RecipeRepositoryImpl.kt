package com.example.recipetesttask.data.repository

import com.example.recipetesttask.data.local.RecipeDao
import com.example.recipetesttask.data.mapper.mapToDomain
import com.example.recipetesttask.data.mapper.mapToEntity
import com.example.recipetesttask.data.remote.ApiService
import com.example.recipetesttask.domain.model.Recipe
import com.example.recipetesttask.domain.repository.RecipeRepository
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

class RecipeRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: RecipeDao
) : RecipeRepository {

   override suspend fun fetchRecipeList(): List<Recipe> {
      return api.fetchRecipeList().map { it.mapToDomain() }
   }

   override suspend fun insertRecipeList(recipeList: List<Recipe>) {
      dao.insertAllRecipe(*recipeList.map { it.mapToEntity() }.toTypedArray())
   }

   override suspend fun getRecipeList(): List<Recipe> {
      return dao.getAllRecipe().map { it.mapToDomain() }
   }



   override suspend fun insertAddRecipe(recipe: Recipe) {
      dao.insertAddRecipe(recipe.mapToEntity())
   }
}