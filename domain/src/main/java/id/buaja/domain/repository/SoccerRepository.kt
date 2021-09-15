package id.buaja.domain.repository

import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import kotlinx.coroutines.flow.Flow

interface SoccerRepository {
    suspend fun getLeague(): Flow<ResultState<List<LeaguesModel>>>
}