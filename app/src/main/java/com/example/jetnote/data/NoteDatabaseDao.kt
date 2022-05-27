package com.example.jetnote.data

import androidx.room.*
import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {

    //    suspend: if it takes to long stop  it,
    //    don't add to getNotes because we should get it even it takes to long
    @Query("SELECT * FROM notes_tbl")
    fun getNotes(): Flow<List<Note>>


    @Query("SELECT * from notes_tbl where id =:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(): Note

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)

}
