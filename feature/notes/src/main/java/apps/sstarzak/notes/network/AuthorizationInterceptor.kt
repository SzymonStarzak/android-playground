package apps.sstarzak.notes.network

import apps.sstarzak.core.session.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(private val sessionManager: SessionManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        if (originalRequest.header(SessionManager.AUTH_HEADER_KEY).isNullOrEmpty()) {
            return chain.proceed(originalRequest)
        }

        val request = originalRequest.newBuilder()
            .removeHeader(SessionManager.AUTH_HEADER_KEY)
            .addHeader(SessionManager.AUTH_HEADER_KEY, sessionManager.bearerToken)
            .build()

        return chain.proceed(request)
    }
}