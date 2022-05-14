package com.example.jetnote.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.R
import com.example.jetnote.components.NoteButton
import com.example.jetnote.components.NoteInputText
import com.example.jetnote.model.Note

@ExperimentalComposeUiApi
@Composable
fun NoteScreen(
    notes: List<Note>, onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit) {
    //    State:
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Icon")
        }, backgroundColor = Color(0xFFDADFE3))

//    Content

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                text = title,
                label = "Title", onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                },
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp)
            )
            NoteInputText(
                text = description, label = "Add a note", onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                },
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp)
            )
            NoteButton(text = "Save", onClick = {
                if(title.isNotEmpty() && description.isNotEmpty()){
                    title = ""
                    description=""
                }
            })
        }
    }

}

@ExperimentalComposeUiApi
@Composable
@Preview
fun NotePreview() {
    NoteScreen(notes = emptyList(), onAddNote = {}, onRemoveNote = {})
}