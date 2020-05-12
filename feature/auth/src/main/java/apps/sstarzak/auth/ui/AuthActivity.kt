package apps.sstarzak.auth.ui

import apps.sstarzak.auth.R
import apps.sstarzak.auth.di.AuthComponentProvider
import apps.sstarzak.core.ui.BaseActivity

class AuthActivity : BaseActivity(R.layout.activity_auth) {

    override fun inject() {
        (application as AuthComponentProvider).provideAuthComponent().inject(this)
    }
}
