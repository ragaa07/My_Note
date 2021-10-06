package com.example.mynote.feature_note.presentaion.add_edit_note

data class AddEditNoteState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
