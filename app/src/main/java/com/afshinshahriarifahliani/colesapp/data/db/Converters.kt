package com.afshinshahriarifahliani.colesapp.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.afshinshahriarifahliani.colesapp.data.db.util.JsonParser
import com.afshinshahriarifahliani.colesapp.data.model.Ingredient
import com.afshinshahriarifahliani.colesapp.data.model.RecipeDetails
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun toIngredientJson(ingredients: List<Ingredient>): String {
        return jsonParser.toJson(
            ingredients,
            object : TypeToken<ArrayList<Ingredient>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromIngredientJson(json: String): List<Ingredient> {
        return jsonParser.fromJson<ArrayList<Ingredient>>(
            json,
            object : TypeToken<ArrayList<Ingredient>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toRecipeDetailsJson(recipeDetails: RecipeDetails): String {
        return jsonParser.toJson(
            recipeDetails,
            object : TypeToken<RecipeDetails>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromRecipeDetailsJson(json: String): RecipeDetails? {
        return jsonParser.fromJson<RecipeDetails>(
            json,
            object : TypeToken<RecipeDetails>() {}.type
        )
    }

}