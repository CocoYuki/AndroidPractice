package com.yirong.aidlclient


import android.accounts.Account
import android.content.ComponentName

import android.content.Intent
import android.content.ServiceConnection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import com.yirong.aidlservice.IMyAidlInterface

import kotlinx.android.synthetic.main.activity_aidl_client.*

class AidlClientActivity : AppCompatActivity(){


    private  var myAIDLService: IMyAidlInterface?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidl_client)
        var conn = MyServiceConnection()
        bindService.setOnClickListener{
            val intent = Intent();
            intent.component = ComponentName("com.yirong.aidlservice","com.yirong.aidlservice.MyAidlService");

            applicationContext.bindService(intent, MyServiceConnection(), BIND_AUTO_CREATE);
            Thread.sleep(3000)
            if(myAIDLService == null){
                Log.e("myAIDLService","null!")
            }
        }
//            intent1.action = "com.yirong.aidlservice.MyAidlService";
//            //从 Android 5.0开始 隐式Intent绑定服务的方式已不能使用,所以这里需要设置Service所在服务端的包名
//            intent1.setPackage("com.yirong.aidlservice");
//            var b = applicationContext.bindService(intent1, conn, Context.BIND_AUTO_CREATE)
//            Log.i("hello",b.toString()+123)
//            Thread.sleep(3000)
//            addAccount()
//        }
        unbindService.setOnClickListener {
            unbindService(conn)
        }
    }

    private fun addAccount() {
        var accountList = ArrayList<Account>()
        var account = Account("111","222")
        if(myAIDLService == null){
            Log.e("myAIDLService","null!")
        }
        if(account == null){
            Log.e("account","null!")
        }
        try {
            myAIDLService!!.addAccount(account)
            accountList.clear()
            accountList .addAll( myAIDLService!!.accountList as ArrayList<Account>)
        }catch (e: RemoteException){
            e.printStackTrace();
        }
    }
    inner class MyServiceConnection: ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.i("","onServicedisConnected()")
            myAIDLService = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.i("","onServiceConnected()")
             myAIDLService = IMyAidlInterface.Stub.asInterface(service);
        }

    }
}
