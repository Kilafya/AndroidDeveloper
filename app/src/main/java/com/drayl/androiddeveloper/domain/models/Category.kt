package com.drayl.androiddeveloper.domain.models

enum class Category(val apiName: String) {
    Java(apiName = "java"),
    Kotlin(apiName = "kotlin"),
    Android(apiName = "android"),
    Patterns(apiName = "patterns"),
    Architecture(apiName = "patterns"),
    Multithreading(apiName = "multithreading"),
    Other(apiName = "other");

    companion object {

        fun getCategoryByName(name: String): Category {
            return Category.values().find { it.apiName == name } ?: Other
        }
    }
}