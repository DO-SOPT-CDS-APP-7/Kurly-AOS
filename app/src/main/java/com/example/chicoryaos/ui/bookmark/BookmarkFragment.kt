package com.example.chicoryaos.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.BottomSheetFragmentBookmarkBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookmarkFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentBookmarkBinding? = null
    private val binding: BottomSheetFragmentBookmarkBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = BottomSheetFragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookmarkAdapter = BookmarkAdapter(requireContext())
        binding.rvWishListOtherConsumerItem.adapter = bookmarkAdapter
        binding.rvWishListPurchaseWithItem.adapter = bookmarkAdapter
        bookmarkAdapter.setBookmarkList(mockBookmarkList)
    }

    companion object {
        const val TAG = "BottomSheetBookmark"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private val mockBookmarkList = listOf<Bookmark>(
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
}
