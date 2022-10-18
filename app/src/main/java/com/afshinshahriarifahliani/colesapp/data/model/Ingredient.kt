package com.afshinshahriarifahliani.colesapp.data.model


import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("ingredient")
    val ingredient: String?
)