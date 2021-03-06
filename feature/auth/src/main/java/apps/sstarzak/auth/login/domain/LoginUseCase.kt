package apps.sstarzak.auth.login.domain

import apps.sstarzak.auth.di.AuthScope
import apps.sstarzak.auth.domain.AuthToken
import apps.sstarzak.auth.domain.UserCredentials
import apps.sstarzak.auth.repository.AuthRepository
import apps.sstarzak.core.common.NetworkResult
import apps.sstarzak.core.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@AuthScope
class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) :
    UseCase<AuthToken, UserCredentials>() {

    override suspend fun run(params: UserCredentials): Flow<NetworkResult<AuthToken>> {
        return try {
            authRepository.login(params).map { NetworkResult.Data(it) }
        } catch (e: Exception) {
            flowOf(NetworkResult.Error(e))
        }
    }
}