package com.anshul.theroadrunner.app

import android.app.Application
import com.anshul.theroadrunner.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}