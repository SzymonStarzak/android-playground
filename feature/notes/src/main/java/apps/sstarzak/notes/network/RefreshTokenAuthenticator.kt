package apps.sstarzak.notes.network

import apps.sstarzak.core.session.SessionManager
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.net.HttpURLConnection

class RefreshTokenAuthenticator(private val sessionManager: SessionManager) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            runBlocking { sessionManager.refresh()}

                return response.request().newBuilder()
                    .removeHeader(SessionManager.AUTH_HEADER_KEY)
                    .addHeader(SessionManager.AUTH_HEADER_KEY, sessionManager.bearerToken)
                    .build()
            }


        return null
    }
}