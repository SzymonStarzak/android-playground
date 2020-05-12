package apps.sstarzak.core.navigation

import android.content.Context

interface AuthNavigator {
    fun navigateToLogin(context: Context)
}

interface FeatureNavigator {
    fun navigateToNotes(context: Context)
}

interface CoreNavigator : AuthNavigator, FeatureNavigator