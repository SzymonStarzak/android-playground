package apps.sstarzak.notes.di

interface NotesComponentProvider {
    fun provideNotesComponent(): NotesComponent
    fun releaseNotesComponent()
}