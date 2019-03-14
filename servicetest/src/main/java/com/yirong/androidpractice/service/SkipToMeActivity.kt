package com.yirong.androidpractice.service

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class SkipToMeActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mIntent = this.getIntent();
        var res = mIntent.getStringExtra("hello");


        Toast.makeText(this,"hello，I'm SkipToMe！The data:"+res,Toast.LENGTH_SHORT).show()
    }
}