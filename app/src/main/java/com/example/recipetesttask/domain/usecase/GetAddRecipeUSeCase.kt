package com.example.recipetesttask.domain.usecase

import com.example.recipetesttask.domain.model.Recipe
import com.example.recipetesttask.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

class GetAddRecipeUSeCase @Inject constructor(
    private val repository: RecipeRepository
) {

   suspend operator fun invoke(recipe:Recipe) {
      return withContext(Dispatchers.IO) {
         repository.insertAddRecipe(recipe)
      }
   }
}