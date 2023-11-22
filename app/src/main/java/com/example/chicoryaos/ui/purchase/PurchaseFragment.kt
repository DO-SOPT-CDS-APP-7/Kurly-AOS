package com.example.chicoryaos.ui.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chicoryaos.databinding.BottomSheetFragmentPurchaseBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentPurchaseBinding? = null
    private val binding: BottomSheetFragmentPurchaseBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = BottomSheetFragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val TAG = "BottomSheetPurchase"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
