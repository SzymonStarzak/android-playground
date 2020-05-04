package apps.sstarzak.auth.data.api.model


import apps.sstarzak.auth.entity.AuthToken
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenResponse(
    @Json(name = "access")
    val access: String,
    @Json(name = "refresh")
    val refresh: String
)

fun TokenResponse.toDomainModel() = AuthToken(accessToken = access, refreshToken = refresh)

@JsonClass(generateAdapter = true)
data class RefreshTokenResponse(
    @Json(name = "access")
    val access: String
)