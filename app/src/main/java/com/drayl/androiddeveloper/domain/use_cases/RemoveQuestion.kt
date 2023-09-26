package com.drayl.androiddeveloper.domain.use_cases

import com.drayl.androiddeveloper.domain.QuestionRepository
import javax.inject.Inject

class RemoveQuestion @Inject constructor(
    private val questionRepository: QuestionRepository,
) {
    suspend operator fun invoke(id: Int) {
        questionRepository.removeQuestion(id)
    }
}