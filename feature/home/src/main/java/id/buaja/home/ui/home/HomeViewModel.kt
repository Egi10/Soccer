package id.buaja.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import id.buaja.domain.usecase.SoccerUseCase
import id.buaja.home.utils.UiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: SoccerUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState<List<LeaguesModel>>(loading = true))
    val uiState: StateFlow<UiState<List<LeaguesModel>>> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            useCase.getLeague()
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
                .collect { result ->
                    when (result) {
                        is ResultState.Success -> {
                            _uiState.update {
                                it.copy(data = result.data)
                            }
                        }

                        is ResultState.Error -> {
                            _uiState.update {
                                it.copy(error = "Error Disini ${result.exception.message}")
                            }
                        }
                    }
                }
        }
    }
}