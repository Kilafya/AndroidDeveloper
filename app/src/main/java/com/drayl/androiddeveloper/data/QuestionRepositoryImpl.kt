package com.drayl.androiddeveloper.data

import com.drayl.androiddeveloper.data.mappers.QuestionsMapper
import com.drayl.androiddeveloper.data.models.QuestionDbModel
import com.drayl.androiddeveloper.data.storages.local.QuestionLocalDataStore
import com.drayl.androiddeveloper.di.annotations.ApplicationScope
import com.drayl.androiddeveloper.domain.QuestionRepository
import com.drayl.androiddeveloper.domain.models.Category
import com.drayl.androiddeveloper.domain.models.Question
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ApplicationScope
class QuestionRepositoryImpl @Inject constructor(
    private val questionsMapper: QuestionsMapper,
    private val localDataStore: QuestionLocalDataStore,
): QuestionRepository {

    private var fullList: List<QuestionDbModel> = listOf()

    override fun getFullListOfQuestionFlow(): Flow<List<Question>> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionsByCategory(categories: List<Category>): List<Question> {
        return fullList
            .filter { questionDbModel ->
                !categories.any { category -> !questionDbModel.categories.contains(category.apiName) }
            }
            .map { questionDbModel ->
                questionsMapper.map(questionDbModel)
            }
    }

    override suspend fun getQuestionByName(name: String): List<Question> {
        return fullList
            .filter { questionDbModel ->
                questionDbModel.title.contains(other = name, ignoreCase = true)
            }
            .map { questionDbModel ->
                questionsMapper.map(questionDbModel)
            }
    }

    override suspend fun getFavoritesQuestions(): List<Question> {
        return fullList
            .filter { questionDbModel -> questionDbModel.isFavorite }
            .map { questionDbModel -> questionsMapper.map(questionDbModel) }
    }

    override suspend fun getUnknownQuestions(): List<Question> {
        return fullList
            .filter { questionDbModel -> !questionDbModel.isAnswerKnown }
            .map { questionDbModel -> questionsMapper.map(questionDbModel) }
    }

    override suspend fun getQuestionById(id: Int): Question {
        return questionsMapper.map(localDataStore.getQuestionById(id))
    }

    override suspend fun addQuestion(question: Question) {
        localDataStore.addQuestion(questionsMapper.map(question))
    }

    override suspend fun editQuestion(question: Question) {
        localDataStore.addQuestion(questionsMapper.map(question))
    }

    override suspend fun removeQuestion(id: Int) {
        localDataStore.removeQuestion(id)
    }
}