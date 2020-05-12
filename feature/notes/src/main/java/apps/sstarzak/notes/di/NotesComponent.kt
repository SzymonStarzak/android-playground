package apps.sstarzak.notes.di

import apps.sstarzak.notes.NotesActivity
import dagger.Subcomponent

@NotesScope
@Subcomponent(
    modules = [
        NotesModule::class,
        NotesNetworkModule::class
    ]
)
interface NotesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesComponent
    }

    fun inject(notesActivity: NotesActivity)
}