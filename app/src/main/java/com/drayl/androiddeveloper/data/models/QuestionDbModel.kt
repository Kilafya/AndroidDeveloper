package com.drayl.androiddeveloper.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.drayl.androiddeveloper.data.models.QuestionDbModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class QuestionDbModel(
    @[PrimaryKey(autoGenerate = true) ColumnInfo(name = COLUMN_ID)]
    val id: Int,
    val title: String,
    val description: List<ContentDbModel>,
    val answer: List<ContentDbModel>,
    val categories: List<String>,
    val isFavorite: Boolean,
    val isAnswerKnown: Boolean,
) {

    companion object {
        const val TABLE_NAME = "questions"
        const val COLUMN_ID = "id"
    }
}