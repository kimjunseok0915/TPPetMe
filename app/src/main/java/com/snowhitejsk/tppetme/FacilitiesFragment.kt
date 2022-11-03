package com.snowhitejsk.tppetme

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
}