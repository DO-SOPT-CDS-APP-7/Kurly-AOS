package com.example.chicoryaos.ui.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.chicoryaos.databinding.BottomSheetFragmentPurchaseBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentPurchaseBinding? = null
    private val binding: BottomSheetFragmentPurchaseBinding
        get() = requireNotNull(_binding)

    private val viewModel by viewModels<PurchaseViewModel>()

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

        initDataBinding()
        viewModel.setPurchasePrice(1000)
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val TAG = "BottomSheetPurchase"
    }
}
