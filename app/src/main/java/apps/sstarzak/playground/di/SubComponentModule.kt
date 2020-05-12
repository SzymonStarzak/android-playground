package apps.sstarzak.playground.di

import apps.sstarzak.auth.di.AuthComponent
import apps.sstarzak.notes.di.NotesComponent
import dagger.Module

@Module(
    subcomponents = [
        AuthComponent::class,
        NotesComponent::class
    ]
)
class SubComponentModule