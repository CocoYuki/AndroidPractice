package com.yirong.androidpractice.service

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.yirong.androidpractice.R
import kotlinx.android.synthetic.main.activity_servicetest.*

class ServiceTestActivity: Activity(){
    private lateinit var intent1:Intent
    private lateinit var intent2:Intent
    private  var isbound:Boolean = false
    private  lateinit  var conn2:MyServiceConnection
    private  lateinit  var conn1:MyServiceConnection
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_servicetest)
            intent2 = Intent(this, MyService::class.java)
            intent1 = Intent(this, MyIntentService::class.java)
            conn2 = MyServiceConnection()
            conn1 = MyServiceConnection()
            startService.setOnClickListener {
                Log.i("ServiceTestActivity","startService")
                startService(intent2)
            }
            bindService.setOnClickListener {
                Log.i("ServiceTestActivity","bindService")
                isbound = bindService(intent2,conn2, Context.BIND_AUTO_CREATE)
            }
            unbindService.setOnClickListener {
                Log.i("ServiceTestActivity","unbindService")
                if(isbound){
                    unbindService(conn2)
                    isbound = false
                }

            }
            stopService.setOnClickListener {
                Log.i("ServiceTestActivity","stopService")
                stopService(intent2)
            }
            startIntentService.setOnClickListener {
                Log.i("ServiceTestActivity","startIntentService")
                startService(intent1)
            }
            bindIntentService.setOnClickListener {
                Log.i("ServiceTestActivity","bindIntentService")
                bindService(intent1,conn1, Context.BIND_AUTO_CREATE)
            }

        }
        private class MyServiceConnection:ServiceConnection{
            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                Log.i("ServiceConnection","onServiceConnected")
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                Log.i("ServiceConnection","onServiceDisconnected")
            }

        }

    override fun onDestroy() {
        super.onDestroy()
        stopService(intent2)
        stopService(intent1)
    }
}