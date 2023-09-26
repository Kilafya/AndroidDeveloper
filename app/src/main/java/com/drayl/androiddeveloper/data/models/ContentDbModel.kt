package com.drayl.androiddeveloper.data.models

data class ContentDbModel(
    val id: Int,
    val type: String,
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val mask: String = "",
    val url: String = "",
)