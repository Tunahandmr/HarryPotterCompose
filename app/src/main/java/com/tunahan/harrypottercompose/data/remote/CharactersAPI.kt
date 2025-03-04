package com.tunahan.harrypottercompose.data.remote

import com.tunahan.harrypottercompose.data.remote.dto.HarryPotterDto
import retrofit2.http.GET

interface CharactersAPI {
    @GET("api/characters")
    suspend fun getCharacters(): HarryPotterDto
}