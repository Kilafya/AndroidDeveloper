package com.drayl.androiddeveloper.domain.use_cases

import com.drayl.androiddeveloper.domain.QuestionRepository
import com.drayl.androiddeveloper.domain.models.Question
import javax.inject.Inject

class GetQuestionById @Inject constructor(
    private val questionRepository: QuestionRepository,
) {
    suspend operator fun invoke(id: Int): Question {
        return questionRepository.getQuestionById(id)
    }
}