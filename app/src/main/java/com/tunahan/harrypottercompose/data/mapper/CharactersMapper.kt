package com.tunahan.harrypottercompose.data.mapper

import com.tunahan.harrypottercompose.data.remote.dto.HarryPotterDto
import com.tunahan.harrypottercompose.domain.model.Characters

fun HarryPotterDto.toCharacters(): List<Characters>{
    return this.map { harry ->
        Characters(
            name = harry.name,
            gender = harry.gender,
            image = harry.image
        )
    }
}