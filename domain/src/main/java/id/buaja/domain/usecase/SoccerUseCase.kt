package id.buaja.domain.usecase

import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import kotlinx.coroutines.flow.Flow

interface SoccerUseCase {
    suspend fun getLeague(): Flow<ResultState<List<LeaguesModel>>>
}