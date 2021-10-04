package com.example.mynote.feature_note.domain.dataInterfaces

import com.example.mynote.feature_note.domain.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun addNote(note: Note)

    suspend fun deleteNote(note: Note)
}