package com.example.mynote.di

import android.app.Application
import androidx.room.Room
import com.example.mynote.feature_note.data.NoteRepositoryImpl
import com.example.mynote.feature_note.data.local_datasource.NoteDatabase
import com.example.mynote.feature_note.domain.NoteUseCases
import com.example.mynote.feature_note.domain.dataInterfaces.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "notes_dp"
        ).build()
    }

    @Provides
    fun providesNoteRepository(dp:NoteDatabase):NoteRepository{
        return NoteRepositoryImpl(dp.noteDao)
    }

    @Provides
    fun providesNoteUseCase(repository: NoteRepository):NoteUseCases{
        return NoteUseCases(repository)
    }
}