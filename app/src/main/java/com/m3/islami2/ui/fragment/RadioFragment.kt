package com.m3.islami2.ui.fragment

import android.content.DialogInterface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.m3.islami2.R
import com.m3.islami2.adapter.RadioAdapter
import com.m3.islami2.api.ApiManager
import com.m3.islami2.base.BaseFragment
import com.m3.islami2.databinding.FragmentHadethBinding
import com.m3.islami2.databinding.FragmentQuranBinding
import com.m3.islami2.databinding.FragmentRadioBinding
import com.m3.islami2.databinding.FragmentTasbehBinding
import com.m3.islami2.model.RadioResponse
import com.m3.islami2.model.RadiosChannel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : BaseFragment() {
    lateinit var adapter: RadioAdapter

    lateinit var binding:FragmentRadioBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRadioBinding.inflate(layoutInflater,container,false)
        return binding.root    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        ApiManager.getApis().getRadioChannels()
            .enqueue(object :Callback<RadioResponse>{
                override fun onResponse(
                    call: Call<RadioResponse>,
                    response: Response<RadioResponse>
                ) {
                    binding.progressBar.visibility=View.GONE
                    if (response.isSuccessful){
                 val data=response.body()
                    adapter.changeData(data?.radios)
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

    private fun setRecyclerView() {
        adapter= RadioAdapter(null)
        binding.recyclerviewRadio.adapter= adapter
        adapter.onStopClickListener=object :RadioAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, radioUrl: RadiosChannel) {
            stopRadio()            }

        }
        adapter.onPlayClickListener=object :RadioAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, radioUrl: RadiosChannel) {
                playRadio(radioUrl.url!!)
            }
        }
    }
    var mediaPlayer=MediaPlayer()
    fun playRadio(url:String){
        stopRadio()
        mediaPlayer.setDataSource(activity!!, Uri.parse(url))
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener{
            it.start()
        }
    }
    fun stopRadio(){
        if (mediaPlayer.isPlaying)
            mediaPlayer.stop()
        mediaPlayer.reset()
    }

}