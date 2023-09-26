package com.drayl.androiddeveloper.data.storages

import com.drayl.androiddeveloper.data.models.QuestionDbModel
import kotlinx.coroutines.flow.Flow

interface QuestionDataStore {

    fun getAllQuestionsFlow(): Flow<List<QuestionDbModel>>

    suspend fun getQuestionById(id: Int): QuestionDbModel

    suspend fun addQuestion(model: QuestionDbModel)

    suspend fun removeQuestion(id: Int)
}