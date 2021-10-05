package com.example.mynote.feature_note.presentaion.note

import com.example.mynote.feature_note.domain.Note
import com.example.mynote.feature_note.domain.util.NoteOrder

sealed class NotesEvent {

    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}