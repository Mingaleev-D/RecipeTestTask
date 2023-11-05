package com.example.recipetesttask.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.centerCropTransform
import com.example.recipetesttask.R
import com.example.recipetesttask.databinding.RecipeItemBinding
import com.example.recipetesttask.domain.model.Recipe

/**
 * @author : Mingaleev D
 * @data : 05.11.2023
 */

class RecipeAdapter : ListAdapter<Recipe, RecipeAdapter.MyViewHolder>(diff) {

   inner class MyViewHolder(val binding: RecipeItemBinding) :
       RecyclerView.ViewHolder(binding.root) {

      fun bind(itemRecipe: Recipe) {
         with(binding) {
            nameTv.text = itemRecipe.name
            descritionTv.text = itemRecipe.description
            caloriesTv.text = itemRecipe.calories
            carbosTv.text = itemRecipe.carbos
            fatsTv.text = itemRecipe.fats
            proteinsTv.text = itemRecipe.proteins
            timeTv.text = itemRecipe.time

            dataImg.loadCircleImage(itemRecipe.image)
         }
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(
          RecipeItemBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
          )
      )
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val item = getItem(position) ?: return

      holder.bind(item)
   }

   private companion object {

      val diff = object : DiffUtil.ItemCallback<Recipe>() {
         override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe) =
             oldItem::class == newItem::class

         override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe) =
             oldItem == newItem

      }
   }
}

fun ImageView.loadCircleImage(path: String?) {
   Glide.with(this.context).load(path)
       .apply(centerCropTransform().error(R.drawable.ic_error).circleCrop()).into(this)
}