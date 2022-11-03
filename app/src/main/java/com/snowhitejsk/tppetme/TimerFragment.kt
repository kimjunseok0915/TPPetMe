package com.snowhitejsk.tppetme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.snowhitejsk.tppetme.databinding.FragmentHomeinfoBinding
import com.snowhitejsk.tppetme.databinding.FragmentTimerBinding

class TimerFragment : Fragment() {
    lateinit var binding: FragmentTimerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimerBinding.inflate(inflater,container,false  )
        return binding.root
    }
}