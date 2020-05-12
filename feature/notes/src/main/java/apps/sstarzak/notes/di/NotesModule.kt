package apps.sstarzak.notes.di

import apps.sstarzak.notes.data.api.NotesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object NotesModule {

    @Provides
    @NotesScope
    fun providesNotesApi(retrofit: Retrofit) = retrofit.create(NotesApi::class.java)
}