package com.m3.islami2.base

import android.R
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

open class BaseActivity: AppCompatActivity() {

    fun showDialoge(){}

    fun makeToast(message:String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()



    }
    fun makeToast(messageID:Int){
        Toast.makeText(this,messageID, Toast.LENGTH_LONG).show()



    }



}