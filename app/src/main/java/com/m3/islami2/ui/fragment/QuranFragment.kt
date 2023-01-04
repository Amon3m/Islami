package com.m3.islami2.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.m3.islami2.Conestent
import com.m3.islami2.adapter.SurasAdapter
import com.m3.islami2.databinding.FragmentQuranBinding
import com.m3.islami2.dialogue.AboutUsSheet
import com.m3.islami2.dialogue.HadethDetailDialogue
import com.m3.islami2.ui.activity.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var surasAdapter: SurasAdapter


    var ArSuras= listOf("الفاتحه", "البقرة", "آل عمران", "النساء", "المائدة", "الأنعام", "الأعراف", "الأنفال", "التوبة", "يونس", "هود"
        , "يوسف", "الرعد", "إبراهيم", "الحجر", "النحل", "الإسراء", "الكهف", "مريم", "طه", "الأنبياء", "الحج", "المؤمنون"
        , "النّور", "الفرقان", "الشعراء", "النّمل", "القصص", "العنكبوت", "الرّوم", "لقمان", "السجدة", "الأحزاب", "سبأ"
        , "فاطر", "يس", "الصافات", "ص", "الزمر", "غافر", "فصّلت", "الشورى", "الزخرف", "الدّخان", "الجاثية", "الأحقاف"
        , "محمد", "الفتح", "الحجرات", "ق", "الذاريات", "الطور", "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة"
        , "الحشر", "الممتحنة", "الصف", "الجمعة", "المنافقون", "التغابن", "الطلاق", "التحريم", "الملك", "القلم", "الحاقة", "المعارج"
        , "نوح", "الجن", "المزّمّل", "المدّثر", "القيامة", "الإنسان", "المرسلات", "النبأ", "النازعات", "عبس", "التكوير", "الإنفطار"
        , "المطفّفين", "الإنشقاق", "البروج", "الطارق", "الأعلى", "الغاشية", "الفجر", "البلد", "الشمس", "الليل", "الضحى", "الشرح"
        , "التين", "العلق", "القدر", "البينة", "الزلزلة", "العاديات", "القارعة", "التكاثر", "العصر",
        "الهمزة", "الفيل", "قريش", "الماعون", "الكوثر", "الكافرون", "النصر", "المسد", "الإخلاص", "الفلق", "الناس")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentQuranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        surasAdapter= SurasAdapter(ArSuras)
        binding.recyclerview.adapter=surasAdapter

        surasAdapter.onItemsClickListener=object : SurasAdapter.OnItemsClickListener{
            override fun OnItemsClick(position: Int, name: String) {
               startSuraDetailsActivity(position,name)
               // showImageDialogeFragment()
            }
        }
    binding.aboutUs.setOnClickListener{

        startAboutUs()

    }
    }

    private fun startAboutUs() {
        val sheet=AboutUsSheet()
        sheet.show(childFragmentManager,"")
    }

//    private fun showImageDialogeFragment() {
//        val dialogue=HadethDetailDialogue()
//        dialogue.show(childFragmentManager,"")
//    }

    private fun startSuraDetailsActivity(position: Int, name: String) {
        var fileName=""+(position+1)+".txt"
        val intent = Intent(context, SuraDetailsActivity::class.java)
        intent.putExtra(Conestent.Extra_Sura_name,name)
        intent.putExtra(Conestent.Extra_File_name,fileName)
        startActivity(intent)

    }

}