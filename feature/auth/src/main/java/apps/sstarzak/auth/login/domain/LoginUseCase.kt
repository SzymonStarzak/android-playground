package apps.sstarzak.auth.login.domain

import apps.sstarzak.auth.entity.AuthToken
import apps.sstarzak.auth.entity.UserCredentials
import apps.sstarzak.auth.repository.AuthRepository
import apps.sstarzak.core.common.NetworkResult
import apps.sstarzak.core.di.AuthScope
import apps.sstarzak.core.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import java.lang.Exception
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