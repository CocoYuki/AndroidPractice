package com.yirong.aidlservice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class AidlServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidl_service)
//
//        startService(Intent(this,MyAidlService::class.java))
    }
}
