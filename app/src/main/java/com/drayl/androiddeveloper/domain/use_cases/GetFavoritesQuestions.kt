package com.drayl.androiddeveloper.domain.use_cases

import com.drayl.androiddeveloper.domain.QuestionRepository
import com.drayl.androiddeveloper.domain.models.Question
import javax.inject.Inject

class GetFavoritesQuestions @Inject constructor(
    private val questionRepository: QuestionRepository,
) {
    suspend operator fun invoke(): List<Question> {
        return questionRepository.getFavoritesQuestions()
    }
}