package com.example.recipetesttask.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.recipetesttask.R
import com.example.recipetesttask.data.common.Resource
import com.example.recipetesttask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
   private val viewModel: RecipeViewModel by viewModels()
   private val recipeAdapter = RecipeAdapter()
   private lateinit var swipeRefresh: SwipeRefreshLayout

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)

      initSwipe()
      initAdapter()
      subscribeObservers()
      intentStartAddActivity()
      // viewModel.getAllRecipeList()
   }

   private fun initSwipe() {
      swipeRefresh = binding.swipeRefresh
      swipeRefresh.setOnRefreshListener {
         viewModel.getAllRecipeList()
      }
   }

   private fun intentStartAddActivity() {
      binding.addImg.setOnClickListener {
         val intent = Intent(this, AddActivity::class.java)
         startActivity(intent)
      }

   }

   private fun subscribeObservers() {
      viewModel.recipeList.observe(this) { result ->
         when (result) {
            is Resource.Error -> {
               binding.progressBar.isVisible = false
               Toast
                   .makeText(
                       this,
                       getString(R.string.an_error_has_occurred_please_try_again),
                       Toast.LENGTH_SHORT
                   )
                   .show()
            }

            is Resource.Loading -> {
               if(swipeRefresh.isRefreshing){
                  swipeRefresh.isRefreshing = false
               }
               binding.progressBar.isVisible = true
            }

            is Resource.Success -> {
               if(swipeRefresh.isRefreshing){
                  swipeRefresh.isRefreshing = false
               }
               binding.progressBar.isVisible = false
               recipeAdapter.submitList(result.data)
            }
         }
      }
   }

   private fun initAdapter() {
      binding.recipeRv.apply {
         adapter = recipeAdapter
      }
   }
}