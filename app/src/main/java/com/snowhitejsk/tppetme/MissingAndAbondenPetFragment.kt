package com.snowhitejsk.tppetme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.snowhitejsk.tppetme.databinding.FragmentFacilitiesBinding
import com.snowhitejsk.tppetme.databinding.FragmentHomeinfoBinding
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

}