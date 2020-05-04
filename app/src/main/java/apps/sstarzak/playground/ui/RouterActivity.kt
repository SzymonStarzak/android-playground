package apps.sstarzak.playground.ui

import android.os.Bundle
import apps.sstarzak.core.ui.BaseActivity
import apps.sstarzak.playground.PlaygroundApplication

class RouterActivity : BaseActivity() {

    override fun inject() {
        (application as PlaygroundApplication).appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coreNavigation.navigateToLogin(this)
        finish()
    }
}