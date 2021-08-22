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
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override suspend fun getAllLeagues(): Flow<ApiResult<List<LeaguesItem>>> {
        return safeApiCall(ioDispatcher) {
            apiService.getAllLeagues().leaguesDetail!!.filter {
                it.strLeague == "Soccer"
            }
        }
    }

    override suspend fun getDetailLeagues(id: String): Flow<ApiResult<LookUpLeagueResponse>> {
        return safeApiCall(ioDispatcher) {
            apiService.getDetailLeagues(id)
        }
    }

    override suspend fun getAllTeamByIdLeagues(id: String): Flow<ApiResult<LookAllTeamsResponse>> {
        return safeApiCall(ioDispatcher) {
            apiService.getAllTeamByIdLeagues(id)
        }
    }
}