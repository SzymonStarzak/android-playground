package apps.sstarzak.playground.di

import android.app.Application
import android.content.Context
import apps.sstarzak.core.di.AppContext
import apps.sstarzak.core.env.Environment
import apps.sstarzak.core.navigation.CoreNavigation
import apps.sstarzak.playground.navigation.Navigation
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(
    includes = [
        AppModule.BindsModule::class
    ]
)
object AppModule {

    @Provides
    fun providesEnvironment(): Environment = Environment.LocalHost()

    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())

    @Module
    interface BindsModule {
        @Binds
        @AppContext
        fun bindsAppContext(application: Application): Context

        @Binds
        @Singleton
        fun bindsNavigation(navigation: Navigation): CoreNavigation
    }
}