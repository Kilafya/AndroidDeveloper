package com.drayl.androiddeveloper.data.mappers

import com.drayl.androiddeveloper.data.models.ContentDbModel
import com.drayl.androiddeveloper.data.models.QuestionDbModel
import com.drayl.androiddeveloper.di.annotations.ApplicationScope
import com.drayl.androiddeveloper.domain.models.Category
import com.drayl.androiddeveloper.domain.models.Content
import com.drayl.androiddeveloper.domain.models.Question
import javax.inject.Inject

@ApplicationScope
class QuestionsMapper @Inject constructor() {

    fun map(entity: QuestionDbModel): Question {
        return Question(
            id = entity.id,
            title = entity.title,
            description = Question.Description(contents = entity.description.mapToContents()),
            answer = Question.Answer(contents = entity.answer.mapToContents()),
            categories = entity.categories.mapToCategories(),
            isFavorite = entity.isFavorite,
            isAnswerKnown = entity.isAnswerKnown,
        )
    }

    fun map(model: Question): QuestionDbModel {
        return QuestionDbModel(
            id = model.id,
            title = model.title,
            description = model.description.contents.mapToDbModels(),
            answer = model.answer.contents.mapToDbModels(),
            categories = model.categories.mapToNames(),
            isFavorite = model.isFavorite,
            isAnswerKnown = model.isAnswerKnown,
        )
    }

    private fun List<String>.mapToCategories(): List<Category> {
        return map { name -> Category.getCategoryByName(name) }
    }

    private fun List<Category>.mapToNames(): List<String> {
        return map { category -> category.apiName }
    }

    private fun List<ContentDbModel>.mapToContents(): List<Content> {
        return map { entity -> map(entity) }
    }

    private fun List<Content>.mapToDbModels(): List<ContentDbModel> {
        return map { model -> map(model) }
    }

    private fun map(entity: ContentDbModel): Content {
        return when (Content.Type.getTypeByName(entity.type)) {
            Content.Type.Title -> {
                Content.Title(
                    id = entity.id,
                    title = entity.title,
                )
            }
            Content.Type.Image -> {
                Content.Image(
                    id = entity.id,
                    description = entity.description,
                    imageUrl = entity.imageUrl,
                )
            }
            Content.Type.Text -> {
                Content.Text(
                    id = entity.id,
                    title = entity.title,
                    description = entity.description,
                )
            }
            Content.Type.Link -> {
                Content.Link(
                    id = entity.id,
                    mask = entity.mask,
                    url = entity.url,
                )
            }
        }
    }

    private fun map(model: Content): ContentDbModel {
        return when(model) {
            is Content.Image -> {
                ContentDbModel(
                    id = model.id,
                    type = model.type,
                    imageUrl = model.imageUrl,
                    description = model.description,
                )
            }
            is Content.Link -> {
                ContentDbModel(
                    id = model.id,
                    type = model.type,
                    mask = model.mask,
                    url = model.url,
                )
            }
            is Content.Text -> {
                ContentDbModel(
                    id = model.id,
                    type = model.type,
                    title = model.title,
                    description = model.description,
                )
            }
            is Content.Title -> {
                ContentDbModel(
                    id = model.id,
                    type = model.type,
                    title = model.title,
                )
            }
        }
    }

}