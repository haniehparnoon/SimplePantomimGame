package com.example.simplepantomimgame.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simplepantomimgame.R
import com.example.simplepantomimgame.databinding.FragmentStartBinding


class StartFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =FragmentStartBinding.inflate(inflater)
        binding.btnPlay.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToGameFragment())
        }
        return binding.root
    }
}