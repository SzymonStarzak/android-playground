package apps.sstarzak.core.session

abstract class SessionManager {

    abstract val tokenStore: TokenStore

    abstract suspend fun refresh()

    fun end() = tokenStore.clear()

    val bearerToken: String get() = "$AUTH_HEADER_PREFIX ${tokenStore.accessToken}"


    companion object {
        const val AUTH_HEADER_KEY = "Authorization"
        const val AUTH_HEADER_PREFIX = "Bearer"
    }
}