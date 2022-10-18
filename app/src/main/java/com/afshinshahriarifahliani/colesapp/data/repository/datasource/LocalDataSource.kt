package com.afshinshahriarifahliani.colesapp.data.repository.datasource

import com.afshinshahriarifahliani.colesapp.data.model.Recipe

interface LocalDataSource {

    suspend fun saveRecipe(recipe: Recipe):Long
}