package com.drayl.androiddeveloper.data.storages.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.drayl.androiddeveloper.data.models.QuestionDbModel

@Database(entities = [QuestionDbModel::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {

    abstract fun questionsDao(): QuestionsDao

    companion object {
        private const val DB_NAME = ""

        private val LOCK = Any()
        private var instance: AppDataBase? = null

        fun getInstance(application: Application): AppDataBase {
            instance?.let { return it }
            synchronized(LOCK) {
                instance?.let {
                    return it
                }
                return Room.databaseBuilder(application, AppDataBase::class.java, DB_NAME,).build()
                    .also { instance = it }
            }
        }
    }
}