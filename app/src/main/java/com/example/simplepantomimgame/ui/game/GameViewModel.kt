package com.example.simplepantomimgame.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {

   private var _score =MutableLiveData(0)
    val score:LiveData<Int>
    get()=_score

   private var _currentWord=MutableLiveData("")
    val currentWord :LiveData<String>
    get()=_currentWord


    var isGameFinished= MutableLiveData(false)
    var wordList= mutableListOf<String>()
    init {
        initialWordList()
        nextWord()
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
        wordList.shuffle()

    }

    fun onSkip() {
        _score.value=_score.value?.minus(1)
        nextWord()
    }
    fun oncorrect() {
        _score.value=_score.value?.plus(1)
        nextWord()
    }
    private fun nextWord() {
        if(wordList.size ==0){
           isGameFinished.value=true

        }else {

            _currentWord.value = wordList.removeAt(0)

        }
    }
}