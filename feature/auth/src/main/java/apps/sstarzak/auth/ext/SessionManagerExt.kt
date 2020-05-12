package apps.sstarzak.auth.ext

import apps.sstarzak.auth.domain.AuthToken
import apps.sstarzak.core.session.SessionManager

fun SessionManager.saveAuthToken(authToken: AuthToken) = with(tokenStore) {
    accessToken = authToken.accessToken
    refreshToken = authToken.refreshToken
}
