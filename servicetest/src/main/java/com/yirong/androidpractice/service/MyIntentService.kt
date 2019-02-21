package com.yirong.androidpractice.service

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyIntentService:IntentService("MyIntentService"){

    override fun onHandleIntent(intent: Intent?) {
        Log.i("MyIntentService","onHandleIntent")
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("MyIntentService","onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("MyIntentService","onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyIntentService","onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("MyIntentService","onBind")
        return super.onBind(intent)
    }
}