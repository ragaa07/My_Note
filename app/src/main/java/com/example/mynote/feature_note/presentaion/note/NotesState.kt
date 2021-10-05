package com.example.mynote.feature_note.presentaion.note

import com.example.mynote.feature_note.domain.Note
import com.example.mynote.feature_note.domain.util.NoteOrder
import com.example.mynote.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
