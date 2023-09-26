package com.drayl.androiddeveloper.domain.models

sealed class Content(
    open val id: Int,
    val type: String,
) {

    data class Title(
        override val id: Int,
        val title: String,
    ): Content(id = id, type = Type.Title.name)

    data class Image(
        override val id: Int,
        val description: String,
        val imageUrl: String,
    ): Content(id = id, type = Type.Image.name)

    data class Text(
        override val id: Int,
        val title: String,
        val description: String,
    ): Content(id = id, type = Type.Text.name)

    data class Link(
        override val id: Int,
        val mask: String,
        val url: String,
    ): Content(id = id, type = Type.Link.name)

    enum class Type(val apiName: String) {
        Title(apiName = "title"),
        Image(apiName = "image"),
        Text(apiName = "text"),
        Link("link");

        companion object {

            fun getTypeByName(name: String): Type {
                return Type.values().find { it.apiName == name } ?: error("Unknown content type")
            }
        }
    }
}
