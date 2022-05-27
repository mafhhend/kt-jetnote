package com.example.jetnote.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "notes_tbl")
data class Note constructor(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,

    val calendar: Calendar = Calendar.getInstance(),
    val Date: Date = Date(),
    @ColumnInfo(name = "note_entry_date")
    var entryDate: String = ""
) {
    init {
        calendar.time = Date
        entryDate =
            "${calendar.get(Calendar.YEAR)}-${calendar.get(Calendar.MONTH)}-${calendar.get(Calendar.DAY_OF_MONTH)}"
    }
}