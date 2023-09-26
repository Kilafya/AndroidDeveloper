package com.drayl.androiddeveloper.presentation.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.drayl.androiddeveloper.presentation.theme.AndroidDeveloperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDeveloperTheme {

            }
        }
    }
}
