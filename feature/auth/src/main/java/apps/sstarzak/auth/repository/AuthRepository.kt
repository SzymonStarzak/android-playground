package apps.sstarzak.auth.repository

import apps.sstarzak.auth.entity.AuthToken
import apps.sstarzak.auth.entity.CreateUserData
import apps.sstarzak.auth.entity.UserCredentials
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(userCredentials: UserCredentials): Flow<AuthToken>

    suspend fun refreshToken(authToken: AuthToken): Flow<AuthToken>

    suspend fun register(createUserData: CreateUserData): Flow<AuthToken>
}
