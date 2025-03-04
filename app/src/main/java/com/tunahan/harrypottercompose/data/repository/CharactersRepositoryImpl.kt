package com.tunahan.harrypottercompose.data.repository

import com.tunahan.harrypottercompose.data.remote.CharactersAPI
import com.tunahan.harrypottercompose.data.remote.dto.HarryPotterDto
import com.tunahan.harrypottercompose.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersAPI: CharactersAPI
): CharactersRepository {
    override suspend fun getCharacters(): HarryPotterDto {
        return charactersAPI.getCharacters()
    }
}