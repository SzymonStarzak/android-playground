package apps.sstarzak.playground.navigation

import android.content.Context
import apps.sstarzak.core.ext.startActivity
import apps.sstarzak.core.navigation.CoreNavigation
import apps.sstarzak.auth.ui.AuthActivity
import apps.sstarzak.notes.NotesActivity
import javax.inject.Inject

class Navigation @Inject constructor(): CoreNavigation {

    override fun navigateToLogin(context: Context) {
        context.startActivity<AuthActivity>()
    }

    override fun navigateToNotes(context: Context) {
        context.startActivity<NotesActivity>()
    }
}