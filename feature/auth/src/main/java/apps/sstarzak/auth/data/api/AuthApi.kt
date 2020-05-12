package apps.sstarzak.auth.data.api

import apps.sstarzak.auth.data.api.model.*
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/jwtauth/token/")
    suspend fun getToken(@Body tokenBody: RequestTokenBody): TokenResponse

    @POST("/api/jwtauth/refresh/")
    suspend fun refreshToken(@Body tokenBody: RequestRefreshTokenBody): RefreshTokenResponse

    @POST("/api/jwtauth/register/")
    suspend fun register(@Body requestRegisterUserBody: RequestRegisterUserBody): TokenResponse
}