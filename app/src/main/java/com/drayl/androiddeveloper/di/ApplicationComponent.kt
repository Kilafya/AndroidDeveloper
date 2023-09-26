package com.drayl.androiddeveloper.di

import android.app.Application
import com.drayl.androiddeveloper.di.annotations.ApplicationScope
import com.drayl.androiddeveloper.presentation.common.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
        ): ApplicationComponent
    }
}