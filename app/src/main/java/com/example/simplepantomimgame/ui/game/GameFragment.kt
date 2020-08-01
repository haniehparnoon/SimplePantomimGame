package com.example.simplepantomimgame.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simplepantomimgame.R
import com.example.simplepantomimgame.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    lateinit var viewModel :GameViewModel
    lateinit var binding: FragmentGameBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=ViewModelProvider(this).get(GameViewModel::class.java)
        binding=FragmentGameBinding.inflate(inflater)
        viewModel.score.observe(viewLifecycleOwner, Observer {
            binding.tvScore.text=it.toString()

        })
        viewModel.currentWord.observe(viewLifecycleOwner, Observer {
            binding.tvWord.text=it.toString()


        })
        viewModel.isGameFinished.observe(viewLifecycleOwner, Observer {
            if(it) gameFinished()
        })


        binding.btnCorrect.setOnClickListener {
           viewModel.oncorrect()


        }
        binding.btnSkip.setOnClickListener {
           viewModel.onSkip()


        }

        return binding.root
    }


   private fun gameFinished (){
       findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(viewModel.score.value?:0))
   }

}