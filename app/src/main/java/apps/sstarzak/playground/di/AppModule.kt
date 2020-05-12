package apps.sstarzak.playground.di

import android.app.Application
import android.content.Context
import apps.sstarzak.auth.di.AuthComponent
import apps.sstarzak.core.env.Environment
import apps.sstarzak.core.navigation.CoreNavigator
import apps.sstarzak.core.session.SessionManager
import apps.sstarzak.core.session.TokenStore
import apps.sstarzak.playground.navigation.Navigator
import apps.sstarzak.playground.session.SessionManagerImpl
import apps.sstarzak.playground.session.TokenStoreImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        AppModule.BindsModule::class
    ]
)
object AppModule {

    @Singleton
    @Provides
    fun providesEnvironment(): Environment = Environment.LocalHost()

    @Provides
    @Singleton
    fun provideSessionManager(
        authComponentFactory: AuthComponent.Factory,
        tokenStore: TokenStore
    ): SessionManager =
        SessionManagerImpl(authComponentFactory, tokenStore)

    @Module
    interface BindsModule {
        @Singleton
        @AppContext
        @Binds
        fun bindsAppContext(application: Application): Context

        @Singleton
        @Binds
        fun bindsNavigator(navigator: Navigator): CoreNavigator

        @Singleton
        @Binds
        fun bindsTokenStore(tokenStore: TokenStoreImpl): TokenStore
    }
}