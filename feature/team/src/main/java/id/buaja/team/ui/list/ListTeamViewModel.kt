package id.buaja.team.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.domain.ResultState
import id.buaja.domain.model.TeamModel
import id.buaja.domain.usecase.SoccerUseCase
import id.buaja.team.UiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListTeamViewModel @Inject constructor(private val useCase: SoccerUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState<List<TeamModel>>(loading = true))
    val uiState: StateFlow<UiState<List<TeamModel>>> = _uiState.asStateFlow()

    fun getAllTeam(id: String) {
        viewModelScope.launch {
            useCase.getAllTeamByIdLeagues(id)
                .onStart {
                    _uiState.update {
                        it.copy(loading = true)
                    }
                }
                .onCompletion {
                    _uiState.update {
                        it.copy(loading = false)
                    }
                }
                .collect {
                    when (it) {
                        is ResultState.Success -> {
                            _uiState.update { state ->
                                state.copy(data = it.data)
                            }
                        }

                        is ResultState.Error -> {
                            _uiState.update { state ->
                                state.copy(error = it.exception.message.toString())
                            }
                        }
                    }
                }
        }
    }
}