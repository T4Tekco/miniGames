package com.android.utils

import android.content.SharedPreferences
import androidx.annotation.Keep
import javax.inject.Inject
@Keep
class SharedPrefsUtils @Inject constructor(private val shared: SharedPreferences) {

    companion object {
        const val PREF_NAME = "SharedPreferences_19213425"
    }

    fun deleteAll() {
        shared.edit().clear().apply()
    }

    fun saveString(key: String, value: String?) {
        val prefEditor = shared.edit()
        prefEditor.putString(key, value)
        prefEditor.apply()
    }

    fun getString(key: String): String? {
        return shared.getString(key, null)
    }

    fun getStringWithDefault(key: String, defaultValue: String): String {
        return shared.getString(key, defaultValue) ?: defaultValue
    }

    fun saveBoolean(key: String, value: Boolean) {
        val prefEditor = shared.edit()
        prefEditor.putBoolean(key, value)
        prefEditor.apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return shared.getBoolean(key, defaultValue)
    }

    fun saveLong(key: String, value: Long) {
        val prefEditor = shared.edit()
        prefEditor.putLong(key, value)
        prefEditor.apply()
    }

    fun getLong(key: String): Long {
        return shared.getLong(key, -1L)
    }

    fun remove(key: String) {
        val prefEditor = shared.edit()
        prefEditor.remove(key)
        prefEditor.apply()
    }


}
