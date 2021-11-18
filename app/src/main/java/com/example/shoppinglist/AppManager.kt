package com.example.shoppinglist

import android.content.Context

object AppManager {

    private const val DARK_MODE_KEY = "daj_pan_3"
    private const val LANGUAGE_KEY = "umamale"

    fun setDarkMode(context: Context, arg: Boolean) {
        val prefs = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean(DARK_MODE_KEY, arg)
        editor.apply()
    }

    fun isDarkMode(context: Context): Boolean {
        val prefs = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getBoolean(DARK_MODE_KEY, false)
    }

    fun setPolish(context: Context, arg: Boolean) {
        val prefs = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean(LANGUAGE_KEY, arg)
        editor.apply()
    }

    fun isPolish(context: Context): Boolean {
        val prefs = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getBoolean(LANGUAGE_KEY, false)
    }
}