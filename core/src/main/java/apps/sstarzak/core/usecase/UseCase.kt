package apps.sstarzak.core.usecase

import apps.sstarzak.core.common.NetworkResult
import kotlinx.coroutines.flow.Flow

// Based on https://github.com/android10/Android-CleanArchitecture-Kotlin/blob/master/app/src/main/kotlin/com/fernandocejas/sample/core/interactor/UseCase.kt
abstract class UseCase<Type, Params> {

    abstract suspend fun run(params: Params): Flow<NetworkResult<Type>>

    suspend operator fun invoke(params: Params) = run(params)

    class None
}