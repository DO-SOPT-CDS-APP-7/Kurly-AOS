package com.example.chicoryaos.ui.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.chicoryaos.databinding.BottomSheetFragmentPurchaseBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentPurchaseBinding? = null
    private val binding: BottomSheetFragmentPurchaseBinding
        get() = requireNotNull(_binding)

    private val viewModel: PurchaseViewModel by activityViewModels()

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
        initSetPurchasePrice()
        initBasketBtnClickListener()
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    private fun initSetPurchasePrice() {
        viewModel.setPurchasePrice(1000)
    }

    private fun initBasketBtnClickListener() {
        binding.btnPurchaseBasket.setOnClickListener {
            dismiss()
            showBasketBottomSheet()
        }
    }

    private fun showBasketBottomSheet() {
        val basketBottomSheet = PurchaseBasketFragment()
        basketBottomSheet.show(parentFragmentManager, PurchaseBasketFragment.TAG)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val TAG = "BottomSheetPurchase"
    }
}
