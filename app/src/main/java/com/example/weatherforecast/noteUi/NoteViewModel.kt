package com.example.weatherforecast.noteUi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.weatherforecast.data.NoteDatabase
import com.example.weatherforecast.data.NoteEntity
import com.example.weatherforecast.data.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

     private val db = Room.databaseBuilder(
        application,
        NoteDatabase::class.java,
        "notes.db"
    )
        .createFromAsset("database/notes.db")
        .build()

    private val dao = NoteDatabase.getDatabase(application).noteDao()
//    private val repository = NoteRepository(db.noteDao())

//    val notesFlow = repository.noteFlow
        val notesFlow = dao.getAllNotes()
    fun addNote(title: String) {
        viewModelScope.launch {
            dao.insertNote(
                NoteEntity(title = title)
            )
        }
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            dao.deleteNote(note)
        }
    }
    fun updateNote(note: NoteEntity, newText : String) {
        viewModelScope.launch {
            dao.updateNote(note.copy(title = newText))
        }
    }
}