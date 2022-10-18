package com.afshinshahriarifahliani.colesapp.domain.repository

import android.content.Context
import com.afshinshahriarifahliani.colesapp.data.model.Recipe
import com.afshinshahriarifahliani.colesapp.data.model.RecipeList

interface ColesRepository {
    suspend fun getSampleRecipes(context: Context): RecipeList

    suspend fun saveRecipe(recipe: Recipe):Long
}