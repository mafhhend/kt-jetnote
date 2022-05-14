package com.example.jetnote.data

import com.example.jetnote.model.Note

class NotesDataSource {
    fun loadNotes():List<Note>{
        return listOf(
            Note(title = "Note 1", description = "Des 1"),
            Note(title = "Note 2", description = "Des 2"),
            Note(title = "Note 3", description = "Des 3"),
            Note(title = "Note 4", description = "Des 4"),
        )
    }
}