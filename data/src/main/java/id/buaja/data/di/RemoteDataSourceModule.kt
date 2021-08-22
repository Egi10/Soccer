package id.buaja.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.source.remote.RemoteDataSource
import id.buaja.data.source.remote.RemoteDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource
}