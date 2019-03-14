package com.yirong.aidlservice


import android.accounts.Account
import android.app.Service
import android.content.Intent

import android.os.IBinder
import android.util.Log

class MyAidlService: Service() {
    private lateinit var mAccountList:ArrayList<Account>

    override fun onBind(intent: Intent?): IBinder? {
        mAccountList = ArrayList()
        var bind = MyBinder()
        Log.i("service MyAidlService","onBind"+bind.toString())
        return bind
    }

    inner class MyBinder: IMyAidlInterface.Stub() {

        override fun getAccountList(): MutableList<Account> {
                return mAccountList
        }


        override fun addAccount(account: Account?) {
            if(account!=null){
                mAccountList.add(account)
                Log.i("111",account.toString())
            }
        }
    }
}