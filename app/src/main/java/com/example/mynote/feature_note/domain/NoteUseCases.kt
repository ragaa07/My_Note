package com.example.mynote.feature_note.domain

import com.example.mynote.feature_note.domain.dataInterfaces.NoteRepository
import com.example.mynote.feature_note.domain.util.NoteOrder
import com.example.mynote.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteUseCases(private val noteRepository: NoteRepository) {

    fun getAllNotes(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return noteRepository.getAllNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }

    suspend fun deleteNotes(note: Note) {
        noteRepository.deleteNote(note)
    }

    @Throws(InvalidNoteException::class)
    suspend fun addNote(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("The note title can't be empty.")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The note content can't be empty.")
        }
        noteRepository.addNote(note = note)
    }
}