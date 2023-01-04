package com.m3.islami2.ui.activity

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar
import com.m3.islami2.R
import com.m3.islami2.base.BaseActivity
import com.m3.islami2.databinding.ActivityHomeBinding
import com.m3.islami2.ui.fragment.HadethFragment
import com.m3.islami2.ui.fragment.QuranFragment
import com.m3.islami2.ui.fragment.TasbehFragment


class HomeActivity : BaseActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //onItemsClickListener
        binding.navigation.setOnItemSelectedListener { item ->
          if (item.itemId==R.id.navigation_quran){

              pushFragmet(QuranFragment())
          }
            else if (item.itemId==R.id.navigation_hadeth){
                pushFragmet(HadethFragment())
          }

            else if (item.itemId==R.id.navigation_tasbeh){
                pushFragmet(TasbehFragment())

//                Snackbar.make(binding.root,"aaa",Snackbar.LENGTH_LONG).setAction("REtry"){}
//                    .show()
//              AlertDialog.Builder(this).setTitle("azyk").setMessage("3amel eh").setCancelable(true).setPositiveButton("yes"){
//                      dialogInterface: DialogInterface, it->finish()
//              }.show()
        }
            true }
        binding.navigation.selectedItemId=R.id.navigation_quran
    }
    fun pushFragmet (fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
            .replace(R.id.fragment_container,fragment).commit()

    }
}