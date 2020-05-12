package apps.sstarzak.notes

import apps.sstarzak.core.ui.BaseActivity
import apps.sstarzak.notes.data.api.NotesApi
import apps.sstarzak.notes.di.NotesComponentProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesActivity : BaseActivity(R.layout.activity_notes) {

    @Inject
    lateinit var notesApi: NotesApi

    override fun inject() {
        (application as NotesComponentProvider).provideNotesComponent().inject(this)
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            notesApi.getNotes()
        }
    }
}