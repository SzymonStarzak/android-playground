package apps.sstarzak.auth.di

import apps.sstarzak.auth.data.AuthRepositoryImpl
import apps.sstarzak.auth.data.api.AuthApi
import apps.sstarzak.auth.repository.AuthRepository
import apps.sstarzak.core.env.Environment
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(
    includes = [
        AuthModule.BindsModule::class
    ]
)
object AuthModule {

    @AuthScope
    @Provides
    @JvmStatic
    fun providesRetrofit(retrofitBuilder: Retrofit.Builder, environment: Environment): Retrofit =
        retrofitBuilder
            .baseUrl(environment.loginBaseUrl)
            .build()

    @AuthScope
    @Provides
    @JvmStatic
    fun providesAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Module
    interface BindsModule {
        @AuthScope
        @Binds
        fun bindsAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
    }
}