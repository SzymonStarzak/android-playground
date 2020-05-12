package apps.sstarzak.core.usecase

import apps.sstarzak.core.common.NetworkResult
import kotlinx.coroutines.flow.Flow

abstract class UseCase<Type, Params> {

    abstract suspend fun run(params: Params): Flow<NetworkResult<Type>>

    suspend operator fun invoke(params: Params) = run(params)

    class None
}