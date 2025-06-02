package com.shokal.cricjass.utlis

import android.app.Application

class MainContext : Application() {
    companion object {
        lateinit var instance: MainContext
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}