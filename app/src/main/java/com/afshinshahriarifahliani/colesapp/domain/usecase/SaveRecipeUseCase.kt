package com.afshinshahriarifahliani.colesapp.domain.usecase

import com.afshinshahriarifahliani.colesapp.data.model.Recipe
import com.afshinshahriarifahliani.colesapp.domain.repository.ColesRepository

class SaveRecipeUseCase(private val repository: ColesRepository) {

    suspend fun execute(recipe: Recipe):Long{
        return repository.saveRecipe(recipe)
    }
}