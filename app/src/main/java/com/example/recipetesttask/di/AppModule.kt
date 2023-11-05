package com.example.recipetesttask.di

import android.content.Context
import androidx.room.Room
import com.example.recipetesttask.data.local.RecipeDao
import com.example.recipetesttask.data.local.RecipeDatabase
import com.example.recipetesttask.data.remote.ApiService
import com.example.recipetesttask.data.remote.ApiService.Companion.BASE_URL
import com.example.recipetesttask.data.repository.RecipeRepositoryImpl
import com.example.recipetesttask.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 *
 * по хорошему нужно разделить модули, но сейчас пока все в одном
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Provides
   @Singleton
   fun provideOkHttpClient(): OkHttpClient {
      return OkHttpClient.Builder()
          .build()
   }

   @Provides
   @Singleton
   fun provideGsonConverterFactory(): GsonConverterFactory {
      return GsonConverterFactory.create()
   }

   @Provides
   @Singleton
   fun provideRecipeApi(
       client: OkHttpClient,
       converterFactory: GsonConverterFactory
   ): ApiService {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(converterFactory)
          .client(client)
          .build()
          .create()
   }

   @Singleton
   @Provides
   fun provideRecipeRepository(
       api: ApiService,
       dao: RecipeDao
   ): RecipeRepository = RecipeRepositoryImpl(api = api, dao = dao)

   @Provides
   @Singleton
   fun provideRecipeDatabase(
       @ApplicationContext context: Context
   ) = Room.databaseBuilder(context, RecipeDatabase::class.java, "DATABASE_NAME").build()

   @Provides
   @Singleton
   fun provideRecipeDao(db: RecipeDatabase) = db.recipeDao()
}