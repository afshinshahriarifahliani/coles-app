package com.afshinshahriarifahliani.colesapp.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    @SerializedName("dynamicDescription")
    val dynamicDescription: String?,
    @SerializedName("dynamicThumbnail")
    val dynamicThumbnail: String?,
    @SerializedName("dynamicThumbnailAlt")
    val dynamicThumbnailAlt: String?,
    @SerializedName("dynamicTitle")
    val dynamicTitle: String?,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>?,
    @SerializedName("recipeDetails")
    val recipeDetails: RecipeDetails?
): Serializable