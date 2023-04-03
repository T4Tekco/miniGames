package com.android.t4tek.app.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.t4tek.app.base.BaseViewModel
import com.android.t4tek.domain.repository.UserRepository
import com.android.t4tek.domain.usecase.FetchPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor(
    private val fetchPersonUseCase: FetchPersonUseCase
) : BaseViewModel() {

    var isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    fun loadUser(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = fetchPersonUseCase()
            Timber.tag("MainActivityVM").i(result.toString())
        }
    }
}