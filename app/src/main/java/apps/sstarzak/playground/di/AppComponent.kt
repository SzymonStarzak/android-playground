package apps.sstarzak.playground.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(application: Application) : Builder
        fun build(): AppComponent
    }
}