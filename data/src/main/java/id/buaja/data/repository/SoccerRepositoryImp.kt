package id.buaja.data.repository

import id.buaja.data.source.remote.RemoteDataSource
import id.buaja.data.utils.DataMapper
import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
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
                            .map { detail ->
                                val resultMap = DataMapper.mapResponseToModel(
                                    leagues = league,
                                    strBadge = detail.leaguesDetail?.get(0)?.strBadge ?: ""
                                )
                                result.addAll(resultMap)
                            }
                    }
                    return@flatMapMerge flow {
                        emit(result)
                    }
                }
                .map {
                    send(ResultState.Success(it))
                }
        }
    }
}