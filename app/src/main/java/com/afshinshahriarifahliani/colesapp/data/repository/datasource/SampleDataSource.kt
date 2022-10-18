package com.afshinshahriarifahliani.colesapp.data.repository.datasource

import android.content.Context
import com.afshinshahriarifahliani.colesapp.data.model.RecipeList

interface SampleDataSource {
    suspend fun getSampleRecipes(context: Context): RecipeList
}