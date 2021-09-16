package id.buaja.data.source.remote

import id.buaja.data.source.remote.network.ApiResult
import id.buaja.data.source.remote.response.LeaguesItem
import id.buaja.data.source.remote.response.LookAllTeamsResponse
import id.buaja.data.source.remote.response.LookUpLeagueResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getAllLeagues(): Flow<List<LeaguesItem>>
    suspend fun getDetailLeagues(id: String): Flow<LookUpLeagueResponse>
    suspend fun getAllTeamByIdLeagues(id: String): Flow<ApiResult<LookAllTeamsResponse>>
}