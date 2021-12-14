package com.bmtbima.appbima.utils

import android.app.Application
import android.content.ContextWrapper
import com.pixplicity.easyprefs.library.Prefs

class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        //instance untuk EasyPrefts nya
        Prefs.Builder()
            .setContext(baseContext)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}