package com.snowhitejsk.tppetme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.snowhitejsk.tppetme.databinding.FragmentFacilitiesBinding
import com.snowhitejsk.tppetme.databinding.FragmentHomeinfoBinding

class FacilitiesFragment : Fragment() {
    lateinit var binding: FragmentFacilitiesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFacilitiesBinding.inflate(inflater,container,false  )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivCafe.setOnClickListener{clickCafe()}
        binding.ivHospital.setOnClickListener{clickHospital()}
        binding.ivPark.setOnClickListener{clickPark()}
        binding.ivTravel.setOnClickListener{clickTravel()}
    }
    fun clickCafe(){
        val intent: Intent = Intent(activity,SearchedListActivity:: class.java)
        intent.putExtra("facility", "애견카페")//애견카페
        startActivity(intent)
    }
    fun clickHospital(){
        val intent: Intent = Intent(activity,SearchedListActivity:: class.java)
        intent.putExtra("facility", "동물병원")//동물병원
        startActivity(intent)
    }
    fun clickPark(){
        val intent: Intent = Intent(activity,SearchedListActivity:: class.java)
        intent.putExtra("facility", "공원")//공원
        startActivity(intent)
    }
    fun clickTravel(){
        val intent: Intent = Intent(activity,SearchedListActivity:: class.java)
        intent.putExtra("facility", "애완동물 호텔")//애완동반 호텔
        startActivity(intent)
    }
}