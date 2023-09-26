package com.drayl.androiddeveloper.presentation.common

import android.app.Application
import com.drayl.androiddeveloper.di.DaggerApplicationComponent

class AndroidDevApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}