package apps.sstarzak.playground

import android.app.Application
import android.util.Log
import apps.sstarzak.auth.di.AuthComponent
import apps.sstarzak.auth.di.AuthComponentProvider
import apps.sstarzak.notes.di.NotesComponent
import apps.sstarzak.notes.di.NotesComponentProvider
import apps.sstarzak.playground.di.AppComponent
import apps.sstarzak.playground.di.DaggerAppComponent
import com.orhanobut.hawk.Hawk

class PlaygroundApplication : Application(), AuthComponentProvider, NotesComponentProvider {

    lateinit var appComponent: AppComponent

    private var authComponent: AuthComponent? = null
    private var notesComponent: NotesComponent? = null

    override fun onCreate() {
        super.onCreate()

        setupHawk()
        setupDagger()
    }

    private fun setupHawk() {
        Hawk.init(this).build()
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

    // region AuthComponentProvider
    override fun provideNotesComponent(): NotesComponent {
        Log.d(TAG, "provideAuthComponent: Creating AuthComponent")
        if (notesComponent == null) {
            notesComponent = appComponent.notesComponent().create()
        }

        return notesComponent as NotesComponent
    }

    override fun releaseNotesComponent() {
        notesComponent = null
    }
    // endregion

    companion object {
        private const val TAG = "PlaygroundApplication"
    }
}