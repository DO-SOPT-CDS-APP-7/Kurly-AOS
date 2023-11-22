package com.example.chicoryaos.ui.purchase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PurchaseViewModel : ViewModel() {
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun increase() {
        count.postValue(count.value?.plus(1))
    }

    fun decrease() {
        if (count.value!! > 0) {
            count.postValue(count.value?.minus(1))
        }
    }
}
