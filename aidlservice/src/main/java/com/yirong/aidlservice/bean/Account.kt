package com.yirong.aidlservice


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Account(val mUsername:String,val mPassword:String):Parcelable{

}