package com.denis.recipebookandroid.model.logger

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpLogs : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.d("NETWORK_LOGS", message)
    }
}

