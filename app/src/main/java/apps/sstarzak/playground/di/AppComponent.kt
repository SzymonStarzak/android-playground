package apps.sstarzak.playground.di

import android.app.Application
import apps.sstarzak.playground.PlaygroundApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<PlaygroundApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(application: Application) : Builder
        fun build(): AppComponent
    }
}