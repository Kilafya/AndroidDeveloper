package com.drayl.androiddeveloper.data.storages.local

import com.drayl.androiddeveloper.data.models.QuestionDbModel
import com.drayl.androiddeveloper.data.storages.QuestionDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuestionLocalDataStore @Inject constructor(
    private val questionsDao: QuestionsDao,
): QuestionDataStore {
    override fun getAllQuestionsFlow(): Flow<List<QuestionDbModel>> {
        return questionsDao.getAllQuestionsFlow()
    }

    override suspend fun getQuestionById(id: Int): QuestionDbModel {
        return questionsDao.getQuestionById(id)
    }

    override suspend fun addQuestion(model: QuestionDbModel) {
        questionsDao.addQuestion(model)
    }

    override suspend fun removeQuestion(id: Int) {
        questionsDao.removeQuestion(id)
    }
}