package apps.sstarzak.playground.session

import apps.sstarzak.auth.di.AuthComponent
import apps.sstarzak.auth.domain.AuthToken
import apps.sstarzak.core.common.NetworkResult
import apps.sstarzak.core.session.SessionManager
import apps.sstarzak.core.session.TokenStore
import kotlinx.coroutines.flow.single

class SessionManagerImpl(
    private val authComponentFactory: AuthComponent.Factory,
    override val tokenStore: TokenStore
) : SessionManager() {

    override suspend fun refresh() {
        val refreshTokenUseCase = authComponentFactory.create().refreshTokenUseCase()
        val authToken = AuthToken(tokenStore.accessToken, tokenStore.refreshToken)

        when (val refreshTokenResult = refreshTokenUseCase(authToken).single()) {
            is NetworkResult.Data -> with(refreshTokenResult.data) {
                tokenStore.accessToken = accessToken
                tokenStore.refreshToken = refreshToken
            }
            is NetworkResult.Error -> throw refreshTokenResult.throwable
        }
    }
}