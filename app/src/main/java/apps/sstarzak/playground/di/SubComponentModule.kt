package apps.sstarzak.playground.di

import apps.sstarzak.auth.di.AuthComponent
import dagger.Module

@Module(
    subcomponents = [
        AuthComponent::class
    ]
)
class SubComponentModule