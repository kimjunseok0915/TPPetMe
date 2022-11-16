package com.snowhitejsk.tppetme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.snowhitejsk.tppetme.databinding.FragmentMissingandabondenpetBinding

class MissingAndAbondenPetFragment : Fragment() {
    lateinit var binding: FragmentMissingandabondenpetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMissingandabondenpetBinding.inflate(inflater,container,false  )
        return binding.root







    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //이미지 태두리 감싸기
        val partImg1: ImageView = binding.ivMissingcat1
        val partImg2: ImageView = binding.ivMissingcat2
        val partImg3: ImageView = binding.ivMissingdog1
        val partImg4: ImageView = binding.ivMissingdog2
        partImg1.clipToOutline = true
        partImg2.clipToOutline = true
        partImg3.clipToOutline = true
        partImg4.clipToOutline = true


        binding.ivMissingdog1.setOnClickListener { clickAbondonmentDog() }
        binding.ivMissingcat1.setOnClickListener { clickAbondonmentCat() }
    }

    fun clickAbondonmentDog(){
        val intent: Intent= Intent(activity,AbondonPetsActivity:: class.java)
        intent.putExtra("upkind", "417000")//강아지 코드
        startActivity(intent)
    }

    fun clickAbondonmentCat(){
        val intent: Intent = Intent(activity,AbondonPetsActivity:: class.java)
        intent.putExtra("upkind","422400")//고양이 코드
        startActivity(intent)
    }

}