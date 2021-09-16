package id.buaja.data.source.remote

import id.buaja.data.di.IoDispatcher
import id.buaja.data.source.remote.network.ApiResult
import id.buaja.data.source.remote.network.ApiService
import id.buaja.data.source.remote.response.LeaguesItem
import id.buaja.data.source.remote.response.LookAllTeamsResponse
import id.buaja.data.source.remote.response.LookUpLeagueResponse
import id.buaja.data.utils.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override suspend fun getAllLeagues(): Flow<List<LeaguesItem>> {
        return flow<List<LeaguesItem>> {
            apiService.getAllLeagues().leaguesDetail!!.filter {
                it.strLeague == "Soccer"
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun getDetailLeagues(id: String): Flow<LookUpLeagueResponse> {
        return flow<LookUpLeagueResponse> {
            apiService.getDetailLeagues(id)
        }.flowOn(ioDispatcher)
    }

    override suspend fun getAllTeamByIdLeagues(id: String): Flow<ApiResult<LookAllTeamsResponse>> {
        return safeApiCall(ioDispatcher) {
            apiService.getAllTeamByIdLeagues(id)
        }
    }
}