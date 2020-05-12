package apps.sstarzak.core.session

interface TokenStore {
    var accessToken: String
    var refreshToken: String

    val isActive get() =  accessToken.isNotEmpty() && refreshToken.isNotEmpty()

    fun clear()
    fun isValid() : Boolean
}