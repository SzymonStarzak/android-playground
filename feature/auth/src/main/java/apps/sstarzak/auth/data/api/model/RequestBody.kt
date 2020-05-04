package apps.sstarzak.auth.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestTokenBody(
    @Json(name = "username")
    val username: String,
    @Json(name = "password")
    val password: String
)

@JsonClass(generateAdapter = true)
data class RequestRefreshTokenBody(
    @Json(name = "refresh")
    val refresh: String
)

@JsonClass(generateAdapter = true)
data class RequestRegisterUserBody(
    @Json(name = "username")
    val username: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "password2")
    val password2: String,
    @Json(name = "email")
    val email: String
)