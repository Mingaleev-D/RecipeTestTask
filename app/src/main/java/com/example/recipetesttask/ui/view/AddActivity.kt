package com.example.recipetesttask.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.recipetesttask.R
import com.example.recipetesttask.databinding.ActivityAddBinding
import com.example.recipetesttask.domain.model.Recipe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddActivity : AppCompatActivity(), View.OnClickListener {

   private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
   private val viewModel: RecipeViewModel by viewModels()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)

      setupArrowBack()

      binding.editNameType.setOnClickListener(this)
      binding.editDescriptionType.setOnClickListener(this)
      binding.btnAddSave.setOnClickListener(this)
   }

   private fun setupArrowBack() {
      binding.arrowBackImg.setOnClickListener {
         onBackPressed()
      }
   }

   override fun onClick(v: View?) {
      if (v != null) {
         when (v.id) {
            R.id.btn_add_save -> {
               val name = binding.editNameType.text.toString().trim { it <= ' ' }
               val description = binding.editDescriptionType.text.toString().trim { it <= ' ' }

               when {
                  TextUtils.isEmpty(name) -> {
                     Toast.makeText(this@AddActivity, "name empty", Toast.LENGTH_SHORT).show()
                  }

                  TextUtils.isEmpty(description) -> {
                     Toast
                         .makeText(this@AddActivity, "description empty", Toast.LENGTH_SHORT)
                         .show()
                  }

                  else -> {
                     val recipe = Recipe(
                         name = name,
                         description = description,
                         calories = "",
                         carbos = "",
                         country = "",
                         fats = "",
                         image = "",
                         proteins = "",
                         time = "",
                         id = ""
                     )
                     viewModel.insertAddRecipe(recipe)

                     Toast
                         .makeText(this@AddActivity, "all data is saved", Toast.LENGTH_SHORT)
                         .show()

                     finish()
                  }
               }
            }
         }
      }
   }
}