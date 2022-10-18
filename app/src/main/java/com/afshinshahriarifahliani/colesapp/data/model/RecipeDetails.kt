package com.afshinshahriarifahliani.colesapp.data.model

import com.google.gson.annotations.SerializedName

data class RecipeDetails(
    @SerializedName("amountLabel")
    val amountLabel: String?,
    @SerializedName("amountNumber")
    val amountNumber: Int = 0,
    @SerializedName("cookTimeAsMinutes")
    val cookTimeAsMinutes: Int = 0,
    @SerializedName("cookingLabel")
    val cookingLabel: String?,
    @SerializedName("cookingTime")
    val cookingTime: String?,
    @SerializedName("prepLabel")
    val prepLabel: String?,
    @SerializedName("prepNote")
    val prepNote: String?,
    @SerializedName("prepTime")
    val prepTime: String?,
    @SerializedName("prepTimeAsMinutes")
    val prepTimeAsMinutes: Int = 0
)