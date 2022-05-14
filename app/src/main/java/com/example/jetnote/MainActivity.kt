package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnote.screen.NoteScreen
import com.example.jetnote.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                androidx.compose.material.Surface(color = MaterialTheme.colors.background) {
                    NoteScreen(notes = emptyList(), onAddNote = {}, onRemoveNote = {})
                }
            }
        }
    }
}