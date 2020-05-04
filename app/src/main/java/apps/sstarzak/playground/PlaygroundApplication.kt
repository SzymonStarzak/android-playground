package apps.sstarzak.playground

import android.app.Application
import android.util.Log
import apps.sstarzak.playground.di.AppComponent
import apps.sstarzak.playground.di.DaggerAppComponent
import apps.sstarzak.auth.di.AuthComponent
import apps.sstarzak.auth.di.AuthComponentProvider

class PlaygroundApplication : Application(), AuthComponentProvider {

    lateinit var appComponent: AppComponent

    private var authComponent: AuthComponent? = null

    override fun onCreate() {
        super.onCreate()

        setupDagger()
    }

    // region Dagger
    private fun setupDagger() {
        appComponent = DaggerAppComponent.builder()
            .bindApplication(this)
            .build()
    }
    // endregion

    // region AuthComponentProvider
    override fun provideAuthComponent(): AuthComponent {
        Log.d(TAG, "provideAuthComponent: Creating AuthComponent")
        if (authComponent == null) {
            authComponent = appComponent.authComponent().create()
        }

        return authComponent as AuthComponent
    }

    override fun releaseAuthComponent() {
        Log.d(TAG, "releaseAuthComponent: Destroy AuthComponent")
        authComponent = null
    }
    // endregion

    companion object {
        private const val TAG = "PlaygroundApplication"
    }
}