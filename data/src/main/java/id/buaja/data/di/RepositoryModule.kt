package id.buaja.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.repository.SoccerRepositoryImp
import id.buaja.domain.repository.SoccerRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsSoccerRepository(
        soccerRepositoryImp: SoccerRepositoryImp
    ): SoccerRepository
}