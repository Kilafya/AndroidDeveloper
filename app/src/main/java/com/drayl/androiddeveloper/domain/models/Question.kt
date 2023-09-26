package com.drayl.androiddeveloper.domain.models

data class Question(
    val id: Int,
    val title: String,
    val description: Description,
    val answer: Answer,
    val categories: List<Category>,
    val isFavorite: Boolean,
    val isAnswerKnown: Boolean,
) {

    @JvmInline
    value class Description(val contents: List<Content>)

    @JvmInline
    value class Answer(val contents: List<Content>)
}
