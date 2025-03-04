package com.tunahan.harrypottercompose.presentation.characters

import com.tunahan.harrypottercompose.domain.model.Characters

data class CharactersState(
    val characters: List<Characters> = emptyList(),
    val loading: Boolean = false,
    val error: String = ""
)
