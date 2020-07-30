package com.example.simplepantomimgame.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simplepantomimgame.R
import com.example.simplepantomimgame.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    var score =0
    var currentWord=""
    var wordList= mutableListOf<String>()
    lateinit var binding: FragmentGameBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentGameBinding.inflate(inflater)
        initialWordList()
        nextWord()
        binding.btnCorrect.setOnClickListener {
            oncorrect()

        }
        binding.btnSkip.setOnClickListener {
           onSkip()

        }

        return binding.root
    }

    private fun initialWordList() {
        wordList= mutableListOf(
            "پاپیروس",
            "شدادگاه تجدید نظر",
            "دادستان عمومی",
            "چهار شنبه سوری پارسال",
            "روح اموات",
            "سفرنامه مارکوپلو",
            "نازک نارنجی",
            "رستوران مکزیکی",
            "گل گاو زبان",
            "ناتالی پرتمن",
            "سگ اقای پتی بل",
            "مخبر الدوله سر سعدی",
            "شتر گاو پلنگ",
            "کروموزوم",
            "محلول",
            "لر",
            "دار المجانین",
            "محسن چاوشی",
            "نراق",
            "سازمان ملل متحد")

    }
    private fun nextWord() {
        if(wordList.size ==0){
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(score))
        }else {

            currentWord = wordList.removeAt(0)
            showWord()
            showScore()
        }
    }

    private fun onSkip() {
        score--
        nextWord()
    }

    private fun oncorrect() {
        score++
        nextWord()
    }


    private fun showWord(){
        binding.tvWord.text=currentWord
    }
    private fun showScore(){
        binding.tvScore.text=score.toString()

    }


}