package com.example.mynote.feature_note.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mynote.ui.theme.*

@Entity
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int
) {
    companion object {
        val noteColor = listOf(RedOrange, RedPink, BabyBlue, Violet, LightGreen)
    }
}

class InvalidNoteException(message: String) : Exception(message)