package com.drayl.androiddeveloper.domain.use_cases

import com.drayl.androiddeveloper.domain.QuestionRepository
import com.drayl.androiddeveloper.domain.models.Category
import com.drayl.androiddeveloper.domain.models.Question
import javax.inject.Inject

class GetQuestionsByCategory @Inject constructor(
    private val questionRepository: QuestionRepository,
) {
    suspend operator fun invoke(categories: List<Category>): List<Question> {
        return questionRepository.getQuestionsByCategory(categories)
    }
}