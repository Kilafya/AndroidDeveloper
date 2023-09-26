package com.drayl.androiddeveloper.di

import android.app.Application
import com.drayl.androiddeveloper.data.QuestionRepositoryImpl
import com.drayl.androiddeveloper.data.storages.local.AppDataBase
import com.drayl.androiddeveloper.data.storages.local.QuestionsDao
import com.drayl.androiddeveloper.di.annotations.ApplicationScope
import com.drayl.androiddeveloper.domain.QuestionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[Binds ApplicationScope]
    fun bindQuestionRepository(impl: QuestionRepositoryImpl): QuestionRepository

    companion object {

        @[Provides ApplicationScope]
        fun provideQuestionsDao(application: Application): QuestionsDao {
            return AppDataBase.getInstance(application).questionsDao()
        }
    }
}