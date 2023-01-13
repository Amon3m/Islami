package com.m3.islami2.ui.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.m3.islami2.R
import com.m3.islami2.api.ApiManager
import com.m3.islami2.base.BaseFragment
import com.m3.islami2.databinding.FragmentHadethBinding
import com.m3.islami2.databinding.FragmentRadioBinding
import com.m3.islami2.databinding.FragmentTasbehBinding
import com.m3.islami2.model.RadioResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RadioFragment : BaseFragment() {
        lateinit var binding: FragmentRadioBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRadioBinding.inflate(layoutInflater,container,false)
        return binding.root    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ApiManager.getApis().getRadioChannels()
            .enqueue(object :Callback<RadioResponse>{
                override fun onResponse(
                    call: Call<RadioResponse>,
                    response: Response<RadioResponse>
                ) {if (response.isSuccessful){
                 val data = response.body()
                    Log.e("data",data.toString())

                }
                }

                override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                    showDialoge(message = "internet issue "+t.localizedMessage,
                    posActionNames = "retry"
                    , posAction = DialogInterface.OnClickListener { dialog, which ->
                            call.enqueue(this)
                            dialog.dismiss()
                        })

                }


            })
    }
}