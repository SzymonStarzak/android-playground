package apps.sstarzak.core.navigation

import android.content.Context

interface AuthNavigation {
    fun navigateToLogin(context: Context)
}

interface FeatureNavigation {
    fun navigateToNotes(context: Context)
}

interface CoreNavigation : AuthNavigation, FeatureNavigation