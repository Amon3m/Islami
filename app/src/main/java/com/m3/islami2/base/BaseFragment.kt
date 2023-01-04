package com.m3.islami2.base

import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment:Fragment() {



    fun makeToast(message:String){
        Toast.makeText(context,message, Toast.LENGTH_LONG).show()



    }
    fun makeToast(messageID:Int){
        Toast.makeText(context,messageID, Toast.LENGTH_LONG).show()



    }
    fun makesnack(message:String){

    AlertDialog.Builder(context).setTitle("azyk").setMessage("3amel eh").setCancelable(true).setPositiveButton("yes"){

            dialogInterface: DialogInterface, it->

    }
    }

}