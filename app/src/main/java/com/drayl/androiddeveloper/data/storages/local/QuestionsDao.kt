package com.drayl.androiddeveloper.data.storages.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.drayl.androiddeveloper.data.models.QuestionDbModel
import com.drayl.androiddeveloper.data.models.QuestionDbModel.Companion.COLUMN_ID
import com.drayl.androiddeveloper.data.models.QuestionDbModel.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionsDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllQuestionsFlow(): Flow<List<QuestionDbModel>>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID=:id")
    suspend fun getQuestionById(id: Int): QuestionDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuestion(model: QuestionDbModel)

    @Query("DELETE FROM $TABLE_NAME WHERE $COLUMN_ID=:id")
    suspend fun removeQuestion(id: Int)
}