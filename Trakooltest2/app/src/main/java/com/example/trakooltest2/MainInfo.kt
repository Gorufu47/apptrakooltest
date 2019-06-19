package com.example.trakooltest2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class MainInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_main)

        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}

