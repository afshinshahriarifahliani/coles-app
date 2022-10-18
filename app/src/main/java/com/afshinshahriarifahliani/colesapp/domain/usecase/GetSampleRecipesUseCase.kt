package com.afshinshahriarifahliani.colesapp.domain.usecase

import android.content.Context
import com.afshinshahriarifahliani.colesapp.data.model.RecipeList
import com.afshinshahriarifahliani.colesapp.domain.repository.ColesRepository

class GetSampleRecipesUseCase(private val repository: ColesRepository) {

    suspend fun execute(context: Context):RecipeList{
        return repository.getSampleRecipes(context)
    }
}