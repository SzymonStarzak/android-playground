package apps.sstarzak.playground.di

import android.app.Application
import apps.sstarzak.core.ui.BaseActivity
import apps.sstarzak.auth.di.AuthComponent
import apps.sstarzak.playground.ui.RouterActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SubComponentModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun authComponent(): AuthComponent.Factory

    fun inject(baseActivity: BaseActivity)
    fun inject(routerActivity: RouterActivity)
}