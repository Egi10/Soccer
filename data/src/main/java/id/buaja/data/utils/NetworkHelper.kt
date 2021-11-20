package id.buaja.data.utils

import id.buaja.data.source.remote.network.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Flow<ApiResult<T>> {
    return flow {
        try {
            emit(ApiResult.Success(apiCall.invoke()))
        } catch (throwable: Throwable) {
            emit(ApiResult.Error(throwable))
        }
    }.flowOn(dispatcher)
}