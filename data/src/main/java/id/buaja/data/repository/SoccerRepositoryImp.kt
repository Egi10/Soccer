package id.buaja.data.repository

import id.buaja.data.source.remote.RemoteDataSource
import id.buaja.data.source.remote.network.ApiResult
import id.buaja.data.utils.DataMapper
import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import id.buaja.domain.repository.SoccerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SoccerRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : SoccerRepository {
    override suspend fun getLeague(): Flow<ResultState<List<LeaguesModel>>> {
        return flow {
            remoteDataSource.getAllLeagues()
                .map {
                    when (it) {
                        is ApiResult.Success -> {
                            val mapperResponse = DataMapper.mapResponseToModel(it.data)
                            emit(ResultState.Success(mapperResponse))
                        }

                        is ApiResult.Error -> {
                            emit(ResultState.Error(it.throwable))
                        }
                    }
                }
        }
    }
}