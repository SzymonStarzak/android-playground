package apps.sstarzak.auth.di

import apps.sstarzak.auth.di.viewmodel.AuthViewModelModule
import apps.sstarzak.auth.login.view.LoginFragment
import apps.sstarzak.core.di.AuthScope
import apps.sstarzak.auth.ui.AuthActivity
import dagger.Subcomponent

@AuthScope
@Subcomponent(
    modules = [
        AuthModule::class,
        AuthViewModelModule::class
    ]
)
interface AuthComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): AuthComponent
    }

    fun inject(authActivity: AuthActivity)
    fun inject(loginFragment: LoginFragment)
}