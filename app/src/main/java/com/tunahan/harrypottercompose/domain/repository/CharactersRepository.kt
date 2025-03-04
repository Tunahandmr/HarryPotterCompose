package com.tunahan.harrypottercompose.domain.repository

import com.tunahan.harrypottercompose.data.remote.dto.HarryPotterDto

interface CharactersRepository {
    suspend fun getCharacters(): HarryPotterDto
}