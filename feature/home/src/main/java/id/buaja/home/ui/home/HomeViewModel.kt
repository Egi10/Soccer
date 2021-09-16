package id.buaja.home.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.domain.usecase.SoccerUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: SoccerUseCase) : ViewModel() {

}