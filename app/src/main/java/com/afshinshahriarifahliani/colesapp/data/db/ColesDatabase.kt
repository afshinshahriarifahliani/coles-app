package com.afshinshahriarifahliani.colesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.afshinshahriarifahliani.colesapp.data.model.Recipe

@Database(
    entities = [Recipe::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract  class ColesDatabase : RoomDatabase(){
    abstract fun getColesDAO():ColesDAO
}