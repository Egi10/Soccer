package id.buaja.data.source.remote

import android.util.Log
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
        return flow {
            val result = apiService.getAllLeagues().leagues?.filter {
                it.strLeagueAlternate == "Premier League" && it.strLeague == "English Premier League" ||
                        it.strLeagueAlternate == "Bundesliga, Fußball-Bundesliga" ||
                        it.strLeagueAlternate == "Serie A" ||
                        it.strLeagueAlternate == "Ligue 1 Uber Eats" ||
                        it.strLeagueAlternate == "La Liga Santander" ||
                        it.strLeagueAlternate == "Liga 1 Indonesia, BRI Liga 1"
            }
            result?.let { emit(it) }
        }.flowOn(ioDispatcher)
    }

    override suspend fun getDetailLeagues(id: String): Flow<LookUpLeagueResponse> {
        return flow {
            emit(apiService.getDetailLeagues(id))
        }.flowOn(ioDispatcher)
    }

    override suspend fun getAllTeamByIdLeagues(id: String): Flow<ApiResult<LookAllTeamsResponse>> {
        return safeApiCall(ioDispatcher) {
            apiService.getAllTeamByIdLeagues(id)
        }
    }
}