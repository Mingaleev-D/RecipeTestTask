package com.example.recipetesttask.data.remote

import com.example.recipetesttask.data.remote.model.RecipeDto
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

interface ApiService {

   companion object {
     const val BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/android-test/"
   }

   @GET("recipes.json")
   suspend fun fetchRecipeList(): List<RecipeDto>
}