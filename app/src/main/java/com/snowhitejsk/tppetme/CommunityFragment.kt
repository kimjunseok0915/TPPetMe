package com.snowhitejsk.tppetme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.snowhitejsk.tppetme.databinding.FragmentCommunityBinding
import com.snowhitejsk.tppetme.databinding.FragmentHomeinfoBinding

class CommunityFragment : Fragment() {
    lateinit var binding: FragmentCommunityBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater,container,false  )
        return binding.root
    }
}