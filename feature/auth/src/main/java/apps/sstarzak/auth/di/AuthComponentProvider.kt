package apps.sstarzak.auth.di

interface AuthComponentProvider {
    fun provideAuthComponent(): AuthComponent
    fun releaseAuthComponent()
}