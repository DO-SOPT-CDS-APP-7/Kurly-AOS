package com.example.chicoryaos.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    companion object {
        const val TAG = "BottomSheetBookmark"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
