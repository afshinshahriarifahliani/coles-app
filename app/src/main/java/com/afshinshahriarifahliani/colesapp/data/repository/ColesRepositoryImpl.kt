package com.afshinshahriarifahliani.colesapp.data.repository

import android.content.Context
import com.afshinshahriarifahliani.colesapp.data.model.Recipe
import com.afshinshahriarifahliani.colesapp.data.model.RecipeList
import com.afshinshahriarifahliani.colesapp.data.repository.datasource.LocalDataSource
import com.afshinshahriarifahliani.colesapp.data.repository.datasource.SampleDataSource
import com.afshinshahriarifahliani.colesapp.domain.repository.ColesRepository

class ColesRepositoryImpl(
    private val sampleDataSource: SampleDataSource,
    private val localDataSource: LocalDataSource
) : ColesRepository {
    override suspend fun getSampleRecipes(context: Context): RecipeList {
        return sampleDataSource.getSampleRecipes(context)
    }

    override suspend fun saveRecipe(recipe: Recipe):Long {
        return localDataSource.saveRecipe(recipe)
    }
}