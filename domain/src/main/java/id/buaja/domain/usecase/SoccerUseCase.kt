package id.buaja.domain.usecase

import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import id.buaja.domain.model.TeamModel
import kotlinx.coroutines.flow.Flow

interface SoccerUseCase {
    suspend fun getLeague(): Flow<ResultState<List<LeaguesModel>>>
    suspend fun getAllTeamByIdLeagues(id: String): Flow<ResultState<List<TeamModel>>>
}