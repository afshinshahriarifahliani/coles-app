package com.afshinshahriarifahliani.colesapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.afshinshahriarifahliani.colesapp.data.model.Recipe
import com.afshinshahriarifahliani.colesapp.data.model.RecipeList
import com.afshinshahriarifahliani.colesapp.domain.usecase.GetSampleRecipesUseCase
import com.afshinshahriarifahliani.colesapp.domain.usecase.SaveRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ColesViewModel @Inject constructor(
    private val app: Application,
    private val getSampleRecipesUseCase: GetSampleRecipesUseCase,
    private val saveRecipeUseCase: SaveRecipeUseCase
) :
    AndroidViewModel(app) {

    private val _recipeList: MutableLiveData<RecipeList> = MutableLiveData()
    val recipeList: LiveData<RecipeList> = _recipeList
    private val _saveRecipeResult: MutableLiveData<Long> = MutableLiveData()
    val saveRecipeResult: LiveData<Long> = _saveRecipeResult

    fun getSampleRecipeList() = viewModelScope.launch(Dispatchers.IO) {


        _recipeList.postValue(getSampleRecipesUseCase.execute(app))
    }

    fun saveRecipe(recipe: Recipe) = viewModelScope.launch(Dispatchers.IO) {
        _saveRecipeResult.postValue(saveRecipeUseCase.execute(recipe))
    }

}