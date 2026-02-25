package com.example.weatherforecast.noteUi

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun EditNoteDialog(
    initialText : String,
    onDismiss : () -> Unit,
    onConfirm : (String) -> Unit
){
    var text by remember { mutableStateOf(initialText) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Edit Note",
                fontSize = 18.sp
            )
        },
        text = {
            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                }
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(text)
                onDismiss()
                }) {
                Text("Save")

            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Preview
@Composable
fun EditNoteDialogPreview(){
    EditNoteDialog("ABc", {}, {"DEf"})
}