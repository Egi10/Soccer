package id.buaja.domain.usecase

import id.buaja.domain.repository.SoccerRepository
import javax.inject.Inject

class SoccerUseCaseImp @Inject constructor(private val repository: SoccerRepository) :
    SoccerUseCase {
    override suspend fun getLeague() = repository.getLeague()
    override suspend fun getAllTeamByIdLeagues(id: String) = repository.getAllTeamByIdLeagues(id)
}