package com.yirong.androidpractice.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService:Service(){
    override fun onBind(p0: Intent?): IBinder? {
        Log.i("MyService","onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("MyService","onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("MyService","onStartCommand")
        return super.onStartCommand(intent, flags, startId)

    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyService","onDestroy")
    }
}