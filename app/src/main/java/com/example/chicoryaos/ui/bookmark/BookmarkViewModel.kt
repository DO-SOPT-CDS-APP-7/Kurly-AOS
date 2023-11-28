package com.example.chicoryaos.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chicoryaos.R

class BookmarkViewModel : ViewModel() {

    private val _bookmarkList = MutableLiveData<List<Bookmark>>()
    val bookmarkList: LiveData<List<Bookmark>>
        get() = _bookmarkList

    init {
        loadBookmarkList()
    }

    private fun loadBookmarkList() {
        val mockBookmarkList = listOf(
            Bookmark(
                productImage = R.drawable.dummy_1,
                productTitle = "[시골보쌈과 감자옹심이]감자 한 모타리에 얼마일까요",
                productPrice = 10500,
            ),
            Bookmark(
                productImage = R.drawable.dummy_2,
                productTitle = "[이연복의 목란]짬뽕 2인분 (맵기선택)",
                productPrice = 13800,
            ),
            Bookmark(
                productImage = R.drawable.dummy_3,
                productTitle = "[방방곡곡]비빔국수키트(2인분)",
                productPrice = 9990,
            ),
        )

        _bookmarkList.value = mockBookmarkList
    }
}
