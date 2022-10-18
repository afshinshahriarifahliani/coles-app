package com.afshinshahriarifahliani.colesapp.data.repository.dataSourceImpl

import android.content.Context
import com.afshinshahriarifahliani.colesapp.data.model.RecipeList
import com.afshinshahriarifahliani.colesapp.data.repository.datasource.SampleDataSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext

class SampleDataSourceImpl : SampleDataSource {
    override suspend fun getSampleRecipes(context: Context): RecipeList {
        val jsonFileString =
            context.assets.open("recipesSample.json").bufferedReader().use { it -> it.readText() }
        val gson = Gson()
        val recipeListType = object : TypeToken<RecipeList>() {}.type
        return gson.fromJson(jsonFileString, recipeListType)
    }
}