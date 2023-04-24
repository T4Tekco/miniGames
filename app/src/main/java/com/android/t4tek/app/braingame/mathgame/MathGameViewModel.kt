//package com.android.t4tek.app.braingame.mathgame
//
//
//import android.content.res.Resources
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.viewModelScope
//import com.android.t4tek.app.base.BaseViewModel
//import com.android.t4tek.domain.repository.QuestionRepository
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//class MathGameViewModel @Inject constructor(
//    private val questionRepository: QuestionRepository
//) : BaseViewModel()
//{
//    private var gameLoader:MutableLiveData<Resources<List<>>>
//
//    fun loadMathGames() {
//        viewModelScope.launch {
//            try {
//                val mathGames = mathGameRepository.getJsonMiniGame()
//                mathGamesLiveData.postValue(mathGames)
//            } catch (exception: Exception) {
//                // Handle the exception here
//            }
//        }
//    }
//}