package apps.sstarzak.auth.entity

data class AuthToken(val accessToken: String, val refreshToken: String)

data class UserCredentials(val userName: String, val password: String)

data class CreateUserData(
    val userName: String,
    val password1: String,
    val password2: String,
    val email: String
)