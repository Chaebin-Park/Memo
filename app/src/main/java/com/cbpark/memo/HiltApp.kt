package com.cbpark.memo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApp: Application() {
  companion object {
    lateinit var INSTANCE: HiltApp
  }

  init {
    INSTANCE = this
  }
}