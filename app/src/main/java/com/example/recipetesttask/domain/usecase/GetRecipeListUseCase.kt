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

class GetRecipeListUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

   suspend operator fun invoke(): List<Recipe> {
      return withContext(Dispatchers.IO) {
         if(repository.getRecipeList().isEmpty()){
            val network = repository.fetchRecipeList()
            repository.insertRecipeList(network)
         }
         return@withContext repository.getRecipeList()
      }
   }
}