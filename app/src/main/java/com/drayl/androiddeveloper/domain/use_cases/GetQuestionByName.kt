package com.drayl.androiddeveloper.domain.use_cases

import com.drayl.androiddeveloper.domain.QuestionRepository
import com.drayl.androiddeveloper.domain.models.Question
import javax.inject.Inject

class GetQuestionByName @Inject constructor(
    private val questionRepository: QuestionRepository,
) {
    suspend operator fun invoke(name: String): List<Question> {
        return questionRepository.getQuestionByName(name)
    }
}