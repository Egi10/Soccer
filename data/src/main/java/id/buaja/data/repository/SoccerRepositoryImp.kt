package id.buaja.data.repository

import android.util.Log
import id.buaja.data.source.remote.RemoteDataSource
import id.buaja.data.source.remote.network.ApiResult
import id.buaja.data.utils.DataMapper
import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import id.buaja.domain.model.TeamModel
import id.buaja.domain.repository.SoccerRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SoccerRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : SoccerRepository {
    @FlowPreview
    @ExperimentalCoroutinesApi
    override suspend fun getLeague(): Flow<ResultState<List<LeaguesModel>>> {
        return channelFlow {
            remoteDataSource.getAllLeagues()
                .flatMapMerge {
                    val result: MutableList<LeaguesModel> = mutableListOf()
                    it.map { league ->
                        remoteDataSource.getDetailLeagues(league.idLeague.toString())
                            .collect { detail ->
                                val resultMap = DataMapper.mapResponseToModel(
                                    leagues = league,
                                    strBadge = detail.leagues?.get(0)?.strBadge ?: ""
                                )
                                result.addAll(resultMap)
                            }
                    }
                    return@flatMapMerge flow {
                        emit(result)
                    }
                }
                .catch { throwable ->
                    send(ResultState.Error(throwable))
                }
                .collect {
                    send(ResultState.Success(it))
                }
        }
    }

    override suspend fun getAllTeamByIdLeagues(id: String): Flow<ResultState<List<TeamModel>>> {
        Log.d("error", "ID $id")
        return flow {
            remoteDataSource.getAllTeamByIdLeagues(id)
                .collect {
                    when(it) {
                        is ApiResult.Success -> {
                            val mapping = DataMapper.mapResponseTeamToModel(it.data)
                            emit(ResultState.Success(mapping))

                            Log.d("error", "${it.data}")
                        }

                        is ApiResult.Error -> {
                            emit(ResultState.Error(it.throwable))

                            Log.d("error", "${it.throwable}")
                        }
                    }

                }
        }
    }
}