package com.afshinshahriarifahliani.colesapp.presentation.di

import com.afshinshahriarifahliani.colesapp.data.db.ColesDAO
import com.afshinshahriarifahliani.colesapp.data.repository.ColesRepositoryImpl
import com.afshinshahriarifahliani.colesapp.data.repository.dataSourceImpl.LocalDataSourceImpl
import com.afshinshahriarifahliani.colesapp.data.repository.dataSourceImpl.SampleDataSourceImpl
import com.afshinshahriarifahliani.colesapp.data.repository.datasource.LocalDataSource
import com.afshinshahriarifahliani.colesapp.data.repository.datasource.SampleDataSource
import com.afshinshahriarifahliani.colesapp.domain.repository.ColesRepository
import com.afshinshahriarifahliani.colesapp.domain.usecase.GetSampleRecipesUseCase
import com.afshinshahriarifahliani.colesapp.domain.usecase.SaveRecipeUseCase
import com.afshinshahriarifahliani.colesapp.presentation.adapter.RecipeAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSampleDataSource():SampleDataSource{
        return SampleDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(colesDAO: ColesDAO):LocalDataSource{
        return LocalDataSourceImpl(colesDAO)
    }

    @Provides
    @Singleton
    fun provideColesRepository(sampleDataSource: SampleDataSource , localDataSource: LocalDataSource ): ColesRepository {
        return ColesRepositoryImpl(sampleDataSource,localDataSource )
    }

    @Provides
    @Singleton
    fun provideGetSampleRecipeUseCase( colesRepository:ColesRepository):GetSampleRecipesUseCase  {
        return GetSampleRecipesUseCase(colesRepository)
    }

    @Provides
    @Singleton
    fun provideSaveRecipeUseCase( colesRepository:ColesRepository):SaveRecipeUseCase  {
        return SaveRecipeUseCase(colesRepository)
    }

    @Singleton
    @Provides
    fun provideRecipeAdapter(): RecipeAdapter {
        return RecipeAdapter()
    }

}