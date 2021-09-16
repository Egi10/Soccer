package id.buaja.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.domain.usecase.SoccerUseCase
import id.buaja.domain.usecase.SoccerUseCaseImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsUseCase(soccerUseCaseImp: SoccerUseCaseImp): SoccerUseCase
}