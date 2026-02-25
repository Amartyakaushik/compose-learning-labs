package com.example.weatherforecast.noteUi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.data.NoteEntity

@Composable
fun NoteItem(
    note: NoteEntity,
    onDelete: () -> Unit,
    onUpdate: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = note.title)

        Row {
            TextButton(onClick = onUpdate) {
                Text("Edit")
            }
            TextButton(onClick = onDelete) {
                Text("Delete")
            }
        }
    }
}
