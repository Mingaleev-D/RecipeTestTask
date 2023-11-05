package com.example.recipetesttask.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipetesttask.data.common.Resource
import com.example.recipetesttask.domain.model.Recipe
import com.example.recipetesttask.domain.usecase.GetAddRecipeUSeCase
import com.example.recipetesttask.domain.usecase.GetRecipeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeListUseCase: GetRecipeListUseCase,
    private val getAddRecipeUSeCase: GetAddRecipeUSeCase
) : ViewModel() {

   private val _recipeList: MutableLiveData<Resource<List<Recipe>>> = MutableLiveData()
   val recipeList: LiveData<Resource<List<Recipe>>>
      get() = _recipeList

   init {
      getAllRecipeList()
   }

   fun getAllRecipeList() {
      viewModelScope.launch() {
         _recipeList.postValue(Resource.Loading())
         try {
            val response = recipeListUseCase()
            _recipeList.postValue(Resource.Success(response))
         } catch (ex: Exception) {
            _recipeList.postValue(ex.message?.let { Resource.Error(it) })
         }
      }
   }

   fun insertAddRecipe(recipe: Recipe) = viewModelScope.launch { getAddRecipeUSeCase(recipe) }
}