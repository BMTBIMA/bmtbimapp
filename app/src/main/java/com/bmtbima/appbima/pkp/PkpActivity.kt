package com.bmtbima.appbima.pkp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bmtbima.appbima.R

class PkpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pkp)

        supportFragmentManager.beginTransaction().replace(R.id.container, LevelFragment())
            .commit()
    }
}