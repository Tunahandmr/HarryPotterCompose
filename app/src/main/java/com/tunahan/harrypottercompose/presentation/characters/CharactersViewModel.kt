package com.tunahan.harrypottercompose.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunahan.harrypottercompose.domain.usecase.CharactersUseCase
import com.tunahan.harrypottercompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    private var job: Job? = null

    init {
        getCharacters()
    }

    private fun getCharacters(){
        job?.cancel()

        job = charactersUseCase.getCharacters().onEach {
            when(it){
                is Resource.Loading ->{
                    _state.value = _state.value.copy(
                        loading = true
                    )
                }
                is Resource.Success ->{
                    _state.value = _state.value.copy(
                        loading = false,
                        characters = it.data ?: emptyList()
                    )
                }
                is Resource.Error ->{
                    _state.value = _state.value.copy(
                        loading = false,
                        error = it.message ?: "Error!"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}