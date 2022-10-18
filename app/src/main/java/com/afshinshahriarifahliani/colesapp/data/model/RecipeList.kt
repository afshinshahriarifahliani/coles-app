package com.afshinshahriarifahliani.colesapp.data.model


import com.google.gson.annotations.SerializedName

data class RecipeList(
    @SerializedName("recipes")
    val recipes: List<Recipe>
)