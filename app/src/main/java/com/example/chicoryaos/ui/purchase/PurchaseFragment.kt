package com.example.chicoryaos.ui.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.chicoryaos.databinding.BottomSheetFragmentPurchaseBinding
import com.example.chicoryaos.model.ResponseProductDTO
import com.example.chicoryaos.ui.detail.DetailViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentPurchaseBinding? = null
    private val binding: BottomSheetFragmentPurchaseBinding
        get() = requireNotNull(_binding)

    private val purchaseViewModel by activityViewModels<PurchaseViewModel>()
    private val detailViewModel by viewModels<DetailViewModel>()

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
        initGetDetailData()
        initBasketBtnClickListener()
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = purchaseViewModel
        binding.vmDetail = detailViewModel
    }

    private fun initGetDetailData() {
        detailViewModel.produce.observe(viewLifecycleOwner) {
            if (it != null) {
                updatePurchaseUI(it)
            } else {
                setViewModelPurchasePrice(0)
            }
        }
    }

    private fun updatePurchaseUI(it: ResponseProductDTO.Product) {
        val discountedAmount = it.originalPrice * (it.discountRate.toDouble() / 100)
        val regularPrice = it.originalPrice - discountedAmount.toInt()
        setViewModelPurchasePrice(regularPrice)
    }

    private fun setViewModelPurchasePrice(price: Int) {
        purchaseViewModel.setPurchasePrice(price)
    }

    private fun initBasketBtnClickListener() {
        binding.btnPurchaseBasket.setOnClickListener {
            dismiss()
            showBasketBottomSheet()
            purchaseViewModel.onPurchaseButtonClick()
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
