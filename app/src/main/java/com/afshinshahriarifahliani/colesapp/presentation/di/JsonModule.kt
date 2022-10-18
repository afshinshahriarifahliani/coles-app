package com.afshinshahriarifahliani.colesapp.presentation.di

import com.afshinshahriarifahliani.colesapp.data.db.Converters
import com.afshinshahriarifahliani.colesapp.data.db.util.GsonParser
import com.afshinshahriarifahliani.colesapp.data.db.util.JsonParser
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class JsonModule {
    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideJsonParser(gson: Gson): JsonParser {
        return GsonParser(gson)
    }

    @Singleton
    @Provides
    fun provideConvertor(jsonParser: JsonParser): Converters {
        return Converters(jsonParser)
    }
}