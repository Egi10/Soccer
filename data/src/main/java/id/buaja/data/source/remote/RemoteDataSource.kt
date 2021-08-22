package id.buaja.data.source.remote

import id.buaja.data.source.remote.network.ApiResult
import id.buaja.data.source.remote.response.LeaguesItem
import id.buaja.data.source.remote.response.LookAllTeamsResponse
import id.buaja.data.source.remote.response.LookUpLeagueResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getAllLeagues(): Flow<ApiResult<List<LeaguesItem>>>
    suspend fun getDetailLeagues(id: String): Flow<ApiResult<LookUpLeagueResponse>>
    suspend fun getAllTeamByIdLeagues(id: String): Flow<ApiResult<LookAllTeamsResponse>>
}