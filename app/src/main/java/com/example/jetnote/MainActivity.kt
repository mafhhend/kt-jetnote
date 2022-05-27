package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnote.data.NotesDataSource
import com.example.jetnote.model.Note
import com.example.jetnote.screen.NoteScreen
import com.example.jetnote.screen.NoteViewModel
import com.example.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                androidx.compose.material.Surface(color = MaterialTheme.colors.background) {
                    val noteViewModel:NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    @Composable
    fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
        var notesList = noteViewModel.getAllNotes()
        NoteScreen(
            notes = notesList,
            onAddNote = {
                noteViewModel.addNote(it)
            },

            onRemoveNote = {
                noteViewModel.removeNote(it)
            })
    }
}