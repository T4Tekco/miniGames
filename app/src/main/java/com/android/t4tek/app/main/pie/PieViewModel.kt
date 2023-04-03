package com.android.t4tek.app.main.pie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.t4tek.app.base.BaseViewModel
import com.android.t4tek.app.utils.Resource
import com.android.t4tek.domain.entity.PersonEntity
import com.android.t4tek.domain.result_handler.StatusResult
import com.android.t4tek.domain.usecase.FetchPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PieViewModel @Inject constructor(
    private val fetchPersonUseCase: FetchPersonUseCase
) : BaseViewModel() {
    private var _personLoader: MutableLiveData<Resource<List<PersonEntity>>> = MutableLiveData()
    val personLoader: LiveData<Resource<List<PersonEntity>>> = _personLoader
    fun fetchPerson() {
        ioScope.launch {
            _personLoader.postValue(Resource.loading())
            val result = fetchPersonUseCase.invoke()
            delay(500)
            if (result.status == StatusResult.Success) {
                val persons = result.dataResult!!
                _personLoader.postValue(Resource.success(persons))
            } else {
                _personLoader.postValue(result.appError?.errorMessage?.let {
                    Resource.error(it)
                })
            }
        }
    }
}