package com.tunahan.harrypottercompose.domain.usecase

import com.tunahan.harrypottercompose.data.mapper.toCharacters
import com.tunahan.harrypottercompose.domain.model.Characters
import com.tunahan.harrypottercompose.domain.repository.CharactersRepository
import com.tunahan.harrypottercompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    fun getCharacters(): Flow<Resource<List<Characters>>> = flow {
        try {
            emit(Resource.Loading())
            val character = charactersRepository.getCharacters()
            if (character.isNotEmpty()){
                emit(Resource.Success(character.toCharacters()))
            }else{
                emit(Resource.Error("No characters found!"))
            }
        }catch (e: Exception){
            emit(Resource.Error(e.message ?: "Error!"))
        }
    }
}