package com.tunahan.harrypottercompose.di

import com.tunahan.harrypottercompose.data.remote.CharactersAPI
import com.tunahan.harrypottercompose.data.repository.CharactersRepositoryImpl
import com.tunahan.harrypottercompose.domain.repository.CharactersRepository
import com.tunahan.harrypottercompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideCharactersAPI(): CharactersAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCharactersRepository(charactersAPI: CharactersAPI): CharactersRepository{
        return CharactersRepositoryImpl(charactersAPI)
    }
}