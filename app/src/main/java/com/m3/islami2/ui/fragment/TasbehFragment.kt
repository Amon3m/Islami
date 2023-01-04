package com.m3.islami2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.m3.islami2.base.BaseFragment
import com.m3.islami2.databinding.FragmentTasbehBinding


@Suppress("UNUSED_EXPRESSION")
class TasbehFragment : BaseFragment() {
lateinit var binding: FragmentTasbehBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentTasbehBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tasbehCount=0
        var totaltasbehCount=0


        binding.spinnerTasbeha.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(context, "Something changed", LENGTH_SHORT).show()
                tasbehCount=0
                binding.tasbehaCount.setText(tasbehCount.toString())

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {


            }
        })

        binding.itemSebha.setOnClickListener{

            tasbehCount++

            totaltasbehCount++

            binding.tasbehaCount.setText(tasbehCount.toString())
            binding.magmo3Tasby7atCount.setText(totaltasbehCount.toString())

        }
        binding.recount.setOnClickListener{
            tasbehCount=0
            totaltasbehCount=0
            binding.tasbehaCount.setText(tasbehCount.toString())
            binding.magmo3Tasby7atCount.setText(totaltasbehCount.toString())


        }
       
       // val text: String =  binding.spinnerTasbeha.getSelectedItem().toString()

    }
}