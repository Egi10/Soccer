package id.buaja.domain.usecase

import id.buaja.domain.ResultState
import id.buaja.domain.model.LeaguesModel
import id.buaja.domain.repository.SoccerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SoccerUseCaseImp @Inject constructor(private val repository: SoccerRepository): SoccerUseCase {
    override suspend fun getLeague(): Flow<ResultState<List<LeaguesModel>>> {
        return repository.getLeague()
    }
}