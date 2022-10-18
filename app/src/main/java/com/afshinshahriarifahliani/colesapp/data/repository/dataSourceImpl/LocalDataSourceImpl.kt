package com.afshinshahriarifahliani.colesapp.data.repository.dataSourceImpl

import com.afshinshahriarifahliani.colesapp.data.db.ColesDAO
import com.afshinshahriarifahliani.colesapp.data.model.Recipe
import com.afshinshahriarifahliani.colesapp.data.repository.datasource.LocalDataSource

class LocalDataSourceImpl(private val colesDAO: ColesDAO): LocalDataSource {
    override suspend fun saveRecipe(recipe: Recipe):Long {
        return colesDAO.saveRecipe(recipe)
    }
}