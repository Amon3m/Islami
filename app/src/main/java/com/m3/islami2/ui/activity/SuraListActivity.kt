package com.m3.islami2.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m3.islami2.adapter.SurasAdapter
import com.m3.islami2.databinding.ActivitySuraListBinding
import com.m3.islami2.Conestent

class SuraListActivity : AppCompatActivity() {
    lateinit var surasAdapter: SurasAdapter
    lateinit var binding: ActivitySuraListBinding

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySuraListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        surasAdapter= SurasAdapter(ArSuras)
        binding.recyclerview.adapter=surasAdapter

        surasAdapter.onItemsClickListener=object : SurasAdapter.OnItemsClickListener{
            override fun OnItemsClick(position: Int, name: String) {
                startSuraDetailsActivity(position,name)

            }
        }}




    private fun startSuraDetailsActivity(position: Int, name: String) {
       var fileName=""+(position+1)+".txt"
        intent = Intent(this, SuraDetailsActivity::class.java)
        intent.putExtra(Conestent.Extra_Sura_name,name)
        intent.putExtra(Conestent.Extra_File_name,fileName)
        startActivity(intent)

    }}
