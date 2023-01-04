package com.m3.islami2.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m3.islami2.adapter.AyaAdapter
import com.m3.islami2.databinding.ActivitySuraDetailsBinding
import com.m3.islami2.Conestent
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class SuraDetailsActivity : AppCompatActivity() {
    lateinit var ayaAdapter: AyaAdapter

    lateinit var binding: ActivitySuraDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val suraName=intent.getStringExtra(Conestent.Extra_Sura_name)
        val fileName=intent.getStringExtra(Conestent.Extra_File_name)?:""

        val ayat = readSuraContent(fileName)
        ayaAdapter= AyaAdapter(ayat)
        binding.recyclerviewAya.adapter=ayaAdapter

        binding.suraTitle.text = suraName



    }

    private fun readSuraContent(fileName: String): List<String> {

        val reader: BufferedReader
        var suraLines= mutableListOf<String>()
        try {
            val file = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line = reader.readLine()
            while (line != null) {
                suraLines.add(line)

                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return suraLines
    }
}
