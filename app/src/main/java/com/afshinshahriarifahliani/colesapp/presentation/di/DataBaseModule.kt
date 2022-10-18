package com.afshinshahriarifahliani.colesapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.afshinshahriarifahliani.colesapp.data.db.ColesDAO
import com.afshinshahriarifahliani.colesapp.data.db.ColesDatabase
import com.afshinshahriarifahliani.colesapp.data.db.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {


    @Provides
    @Singleton
    fun provideColesDatabase(app: Application , converters: Converters): ColesDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            ColesDatabase::class.java,
            "coles_db"
        )
            .addTypeConverter(converters)
            .build()
    }


    @Provides
    @Singleton
    fun provideColesDao(colesDatabase: ColesDatabase): ColesDAO {
        return colesDatabase.getColesDAO()
    }
}