package com.example.shoppinglist

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import java.util.*

class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        val switch = findViewById<Switch>(R.id.switch1)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.languages,
            android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = it
        }

        var isDarkMode = AppManager.isDarkMode(this)
        var isPolish = AppManager.isPolish(this)
        switch.isChecked = isDarkMode

        switch.setOnClickListener {
            isDarkMode = !isDarkMode
            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            AppManager.setDarkMode(this, isDarkMode)
        }

        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position==0){
                    AppManager.setPolish(this@OptionsActivity, false)
                    val locale= Locale.getDefault()
                    val config = this@OptionsActivity.resources.configuration
                    config.setLocale(locale)
                    resources.updateConfiguration(config, this@OptionsActivity.resources.displayMetrics)
                }else{
                    AppManager.setPolish(this@OptionsActivity, true)
                    val locale= Locale("pl")
                    val config = this@OptionsActivity.resources.configuration
                    config.setLocale(locale)
                    resources.updateConfiguration(config, this@OptionsActivity.resources.displayMetrics)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }
}