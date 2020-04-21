package apps.sstarzak.playground

import apps.sstarzak.playground.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class PlaygroundApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .bindApplication(this)
            .build()

}