package apps.sstarzak.auth.data

import apps.sstarzak.auth.data.api.AuthApi
import apps.sstarzak.auth.data.api.model.RequestTokenBody
import apps.sstarzak.auth.data.api.model.toDomainModel
import apps.sstarzak.auth.entity.AuthToken
import apps.sstarzak.auth.entity.CreateUserData
import apps.sstarzak.auth.entity.UserCredentials
import apps.sstarzak.auth.repository.AuthRepository
import apps.sstarzak.core.di.AuthScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AuthScope
class AuthRepositoryImpl
@Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun login(userCredentials: UserCredentials): Flow<AuthToken> =
        flowOf(
            authApi.getToken(RequestTokenBody(userCredentials.userName, userCredentials.password))
        ).map { it.toDomainModel() }

    override suspend fun refreshToken(authToken: AuthToken): Flow<AuthToken> {
        TODO("Not yet implemented")
    }

    override suspend fun register(createUserData: CreateUserData): Flow<AuthToken> {
        TODO("Not yet implemented")
    }
}