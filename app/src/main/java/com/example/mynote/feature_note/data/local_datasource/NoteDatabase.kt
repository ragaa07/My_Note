package com.example.mynote.feature_note.data.local_datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynote.feature_note.domain.Note


@Database(entities = [Note::class],version = 1)

abstract class NoteDatabase:RoomDatabase() {

    abstract val noteDao:NoteDao
}