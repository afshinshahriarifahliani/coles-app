package com.afshinshahriarifahliani.colesapp.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afshinshahriarifahliani.colesapp.R
import com.afshinshahriarifahliani.colesapp.data.model.Recipe
import com.afshinshahriarifahliani.colesapp.databinding.RecipeCardviewBinding
import com.afshinshahriarifahliani.colesapp.domain.repository.util.BASE_URL
import com.afshinshahriarifahliani.colesapp.domain.repository.util.getCircularProgress
import com.afshinshahriarifahliani.colesapp.domain.repository.util.loadImage

class RecipeAdapter :
    ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(RecipeDiffCallBack()) {
    class RecipeDiffCallBack : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = RecipeCardviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) =
        holder.bind(getItem(position))

    fun swapData(data: List<Recipe>) {
        submitList(data.toMutableList())
    }

    inner class RecipeViewHolder(
        private val binding: RecipeCardviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(recipe: Recipe) {
            binding.apply {

                dynamicThumbnail.loadImage(
                    BASE_URL + recipe.dynamicThumbnail,
                    getCircularProgress(dynamicThumbnail.context)
                )

                recipeTxt.text = "RECIPE"
                Log.i("RECTAG", "bind: ${recipe.dynamicTitle}")
                dynamicTitle.text = recipe.dynamicTitle


            }
            binding.root.setOnClickListener {
                onItemClickListener?.let { anonymous ->
                    anonymous(recipe)
                }
            }
        }

    }

    private var onItemClickListener: ((Recipe) -> Unit)? = null

    fun setOnItemClickListener(listener: (Recipe) -> Unit) {
        onItemClickListener = listener
    }


}