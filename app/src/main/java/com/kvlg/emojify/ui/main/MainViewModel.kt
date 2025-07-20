package com.kvlg.emojify.ui.main

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import com.kvlg.emojify.domain.AppSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Konstantin Koval
 * @since 06.04.2021
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val appSettings: AppSettings,
    private val preferences: SharedPreferences
) : ViewModel() {

    val isLightTheme = mutableStateOf(appSettings.isLightTheme())
    var showInAppReview = mutableStateOf(false)

    init {
        checkForInAppReview()
    }


    fun switchThemes() {
        appSettings.switchThemes()
        isLightTheme.value = appSettings.isLightTheme()
    }


    private fun checkForInAppReview() {
        val current = preferences.getInt(APP_ENTERS_COUNT_KEY, 1)
        if (current % 20 == 0) {
            showInAppReview.value = true
        }
        preferences.edit {
            putInt(APP_ENTERS_COUNT_KEY, current + 1)
        }
    }

    companion object {
        private const val APP_ENTERS_COUNT_KEY = "APP_ENTERS_COUNT_KEY"
    }
}