package apps.sstarzak.notes.network

import okhttp3.Interceptor
import okhttp3.Response

class StatusCodeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        if(response.code() != 403) {
            return response
        }

        return response.newBuilder().code(401).build()
    }
}