package com.yirong.startactivityother

import android.content.ComponentName
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var comp = ComponentName("com.yirong.androidpractice","com.yirong.androidpractice.service.SkipToMeActivity")
        try {
            var intent = Intent()
            var bundle = Bundle()
            bundle.putString("hello","startActivityOther把值传给你了！")
            intent.putExtras(bundle)
            intent.component = comp
            startActivity(intent)
        } catch (e: Exception) {

            Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！", 0).show();

        }

    }
}
