package com.m3.islami2.dialogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.m3.islami2.databinding.AboutUsBinding

class AboutUsSheet:BottomSheetDialogFragment() {lateinit var binding: AboutUsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=AboutUsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}