package apps.sstarzak.notes.di

import apps.sstarzak.core.env.Environment
import apps.sstarzak.core.session.SessionManager
import apps.sstarzak.notes.network.AuthorizationInterceptor
import apps.sstarzak.notes.network.RefreshTokenAuthenticator
import apps.sstarzak.notes.network.StatusCodeInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
object NotesNetworkModule {

    @Provides
    @NotesScope
    fun providesAuthInterceptor(sessionManager: SessionManager): AuthorizationInterceptor =
        AuthorizationInterceptor(sessionManager)

    @Provides
    @NotesScope
    fun providesStatusCodeInterceptor(): StatusCodeInterceptor =
        StatusCodeInterceptor()

    @Provides
    @NotesScope
    fun provideRefreshTokenAuthenticator(sessionManager: SessionManager): RefreshTokenAuthenticator =
        RefreshTokenAuthenticator(sessionManager)

    @Provides
    @NotesScope
    fun providesOkHttpClient(
        okHttpClientBuilder: OkHttpClient.Builder,
        authorizationInterceptor: AuthorizationInterceptor,
        statusCodeInterceptor: StatusCodeInterceptor,
        refreshTokenAuthenticator: RefreshTokenAuthenticator
    ): OkHttpClient = okHttpClientBuilder
        .addNetworkInterceptor(authorizationInterceptor)
        .addNetworkInterceptor(statusCodeInterceptor)
        .authenticator(refreshTokenAuthenticator)
        .build()

    @Provides
    @NotesScope
    fun providesRetrofit(
        retrofitBuilder: Retrofit.Builder,
        okHttpClient: OkHttpClient,
        environment: Environment
    ): Retrofit = retrofitBuilder
        .baseUrl(environment.notesApiBaseUrl)
        .client(okHttpClient)
        .build()
}