package com.afshinshahriarifahliani.colesapp.data.db

import androidx.room.*
import com.afshinshahriarifahliani.colesapp.data.model.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface ColesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipe(recipe: Recipe): Long

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): Flow<List<Recipe>>
}