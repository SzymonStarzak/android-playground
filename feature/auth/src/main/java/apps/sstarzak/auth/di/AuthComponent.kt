package apps.sstarzak.auth.di

import apps.sstarzak.auth.di.viewmodel.AuthViewModelModule
import apps.sstarzak.auth.login.view.LoginFragment
import apps.sstarzak.auth.refresh.domain.RefreshTokenUseCase
import apps.sstarzak.auth.ui.AuthActivity
import apps.sstarzak.core.session.SessionManager
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

    /**
     * Expose refresh token use case for [SessionManager]
     */
    fun refreshTokenUseCase(): RefreshTokenUseCase

    fun inject(authActivity: AuthActivity)
    fun inject(loginFragment: LoginFragment)
}