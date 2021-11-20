package id.buaja.domain.repository

import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import id.buaja.domain.model.TeamModel
import kotlinx.coroutines.flow.Flow

interface SoccerRepository {
    suspend fun getLeague(): Flow<ResultState<List<LeaguesModel>>>
    suspend fun getAllTeamByIdLeagues(id: String): Flow<ResultState<List<TeamModel>>>
}