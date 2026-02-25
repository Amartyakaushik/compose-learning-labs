package com.example.weatherforecast.data

import kotlinx.coroutines.flow.Flow

class NoteRepository(private val dao: NoteDao) {
    val noteFlow : Flow<List<NoteEntity>> = dao.getAllNotes()
    suspend fun insertNote(note : NoteEntity){
        dao.insertNote(note)
    }
}