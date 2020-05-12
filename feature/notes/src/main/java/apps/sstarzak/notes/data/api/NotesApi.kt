package apps.sstarzak.notes.data.api

import apps.sstarzak.notes.data.api.model.Note
import retrofit2.http.GET

interface NotesApi {

    @GET("/api/notes/")
    suspend fun getNotes(): List<Note>
}