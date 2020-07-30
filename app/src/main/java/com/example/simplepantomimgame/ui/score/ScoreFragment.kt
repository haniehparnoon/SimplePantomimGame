package com.example.simplepantomimgame.ui.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simplepantomimgame.R
import com.example.simplepantomimgame.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {
lateinit var binding:FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentScoreBinding.inflate(inflater)


        if (arguments!=null){
            val scoreFragmentArgs = ScoreFragmentArgs.fromBundle(requireArguments())
            binding.tvScore2.text = scoreFragmentArgs.score.toString()
        }

        binding.btnReplay.setOnClickListener {
            findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToGameFragment())
        }

        return binding.root
    }
    }

