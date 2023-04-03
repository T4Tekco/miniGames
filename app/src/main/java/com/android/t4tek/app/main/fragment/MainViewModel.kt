package com.android.t4tek.app.main.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.t4tek.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

}