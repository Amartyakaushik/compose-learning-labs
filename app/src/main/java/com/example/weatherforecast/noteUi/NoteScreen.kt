package com.example.weatherforecast.noteUi

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecast.data.NoteEntity

@Composable
fun NoteScreen() {
//    val viewModel: NoteViewModel =
//        ViewModelProvider(
//            context as ComponentActivity
//        )[NoteViewModel::class.java]
    val context = LocalContext.current
    val activity = context as? ComponentActivity
        ?: throw IllegalStateException("Context is not an Activity")

    val viewModel: NoteViewModel = remember {
        ViewModelProvider(activity)[NoteViewModel::class.java]
    }
    val notes by viewModel.notesFlow.collectAsState(initial = emptyList())
    var text by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var selectedNote by remember { mutableStateOf<NoteEntity?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter note") }
        )

        Button(
            onClick = {
                viewModel.addNote(text)
                text = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add")
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(notes) { note ->
                NoteItem(
                    note = note,
                    onDelete = { viewModel.deleteNote(note) },
                    onUpdate = {
                        selectedNote = note
                        showDialog = true
                    }
                )
            }
        }
    }

    if(showDialog && selectedNote != null) {
        EditNoteDialog(
            initialText = selectedNote!!.title,
            onDismiss = { showDialog = false},
            onConfirm = { viewModel.updateNote(selectedNote!!, it)}
        )
    }
}

@Preview
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}