package com.drayl.androiddeveloper.domain

import com.drayl.androiddeveloper.domain.models.Category
import com.drayl.androiddeveloper.domain.models.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {

    fun getFullListOfQuestionFlow(): Flow<List<Question>>

    suspend fun getQuestionsByCategory(categories: List<Category>): List<Question>

    suspend fun getQuestionByName(name: String): List<Question>

    suspend fun getFavoritesQuestions(): List<Question>

    suspend fun getUnknownQuestions(): List<Question>

    suspend fun getQuestionById(id: Int): Question

    suspend fun addQuestion(question: Question)

    suspend fun editQuestion(question: Question)

    suspend fun removeQuestion(id: Int)
}