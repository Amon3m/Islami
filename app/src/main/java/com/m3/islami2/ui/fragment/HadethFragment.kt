package com.m3.islami2.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.m3.islami2.R
import com.m3.islami2.adapter.HadethAdpter
import com.m3.islami2.adapter.SurasAdapter
import com.m3.islami2.databinding.FragmentHadethBinding
import com.m3.islami2.dialogue.HadethDetailDialogue
import com.m3.islami2.model.HadethModel
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class HadethFragment : Fragment() {

lateinit var binding: FragmentHadethBinding
lateinit var hadethAdpter: HadethAdpter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHadethBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ahadethList =readHadethContent()
        hadethAdpter=HadethAdpter(ahadethList)
        binding.recyclerview.adapter=hadethAdpter
        hadethAdpter.onItemsClickListener=object : HadethAdpter.OnItemsClickListener{
            override fun OnItemsClick(position: Int, model: HadethModel) {
                showHadethDetailsDialogue(position, model)
               // HadethDetailDialogue().binding.hadethText.setText(model.content)
            }
        }


    }

    private fun showHadethDetailsDialogue(position: Int, model: HadethModel) {
        val dialogue= HadethDetailDialogue(position, model)
        dialogue.show(childFragmentManager,"")
    }

    private fun readHadethContent(): List<HadethModel> {


        var ahadethList= mutableListOf<HadethModel>()

        val reader: BufferedReader
        try {
            val file: InputStream? = activity?.assets?.open("ahadeth.txt")
            reader = BufferedReader(InputStreamReader(file))
            var line :String?= reader.readLine()
            while (line != null) {

                val title=line

                line = reader.readLine()

                var content =""
                while (!line.equals("#")){
                    content+=line+" "
                    line=reader.readLine()

                }
                line = reader.readLine()
                val hadeth=HadethModel(title = title, content = content)
                ahadethList.add(hadeth)
                Log.e("title",title)
                Log.e("content",content)
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return ahadethList
    }
}