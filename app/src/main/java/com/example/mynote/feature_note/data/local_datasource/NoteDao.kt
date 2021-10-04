package com.example.mynote.feature_note.data.local_datasource

import androidx.room.*
import com.example.mynote.feature_note.domain.Note
import kotlinx.coroutines.flow.Flow

typealias Notes = List<Note>

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<Notes>

    @Query("SELECT * FROM note WHERE id= :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}