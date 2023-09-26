package com.drayl.androiddeveloper.domain.use_cases

import com.drayl.androiddeveloper.domain.QuestionRepository
import com.drayl.androiddeveloper.domain.models.Question
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFullListOfQuestion @Inject constructor(
    private val questionRepository: QuestionRepository,
) {
    operator fun invoke(): Flow<List<Question>> {
        return questionRepository.getFullListOfQuestionFlow()
    }
}