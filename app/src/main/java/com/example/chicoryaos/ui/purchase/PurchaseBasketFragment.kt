package com.example.chicoryaos.ui.purchase

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import coil.load
import com.example.chicoryaos.databinding.BottomSheetFragmentPurchaseBasketBinding
import com.example.chicoryaos.model.PriceEntity
import com.example.chicoryaos.model.ResponseProductDTO
import com.example.chicoryaos.ui.detail.DetailViewModel
import com.example.chicoryaos.ui.purchase.receipt.PurchaseReceiptActivity
import com.example.chicoryaos.util.extensions.AnimateProgressBar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseBasketFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentPurchaseBasketBinding? = null
    private val binding: BottomSheetFragmentPurchaseBasketBinding
        get() = requireNotNull(_binding)

    private val purchaseViewModel by activityViewModels<PurchaseViewModel>()
    private val detailViewModel by viewModels<DetailViewModel>()

    private val productEntity = PriceEntity(
        id = 1,
        count = 0,
        deliveryType = "",
        productName = "",
        originalPrice = 0,
        discountedPrice = 0,
        imageUrl = "",
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = BottomSheetFragmentPurchaseBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataBinding()
        initGetDetailData()
        initProgressAnimation()
        initDirectBuyBtnClickListener()
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = purchaseViewModel
    }

    private fun initGetDetailData() {
        detailViewModel.produce.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.ivBasketImg.load(it.imageURL)
                setProductEntityDetailData(it)
            }
        }
    }

    private fun setProductEntityDetailData(it: ResponseProductDTO.Product) {
        productEntity.deliveryType = it.deliveryType
        productEntity.productName = it.productName
        productEntity.originalPrice = it.originalPrice
        productEntity.imageUrl = it.imageURL
    }

    private fun initProgressAnimation() {
        val progressBar = binding.pgBasket
        val anim = AnimateProgressBar(
            progressBar,
            0f,
            (purchaseViewModel.purchaseProgress.value ?: 0).toFloat(),
        )
        anim.duration = 1500
        progressBar.startAnimation(anim)
    }

    private fun initDirectBuyBtnClickListener() {
        binding.btnBasketBuy.setOnClickListener {
            setProductEntityPurchaseData()
            startPurchaseReceiptActivity(productEntity)
        }
    }

    private fun setProductEntityPurchaseData() {
        productEntity.count = purchaseViewModel.count.value ?: 0
        productEntity.discountedPrice = purchaseViewModel.price ?: 0
    }

    private fun startPurchaseReceiptActivity(priceEntity: PriceEntity) {
        val intent = Intent(requireContext(), PurchaseReceiptActivity::class.java)
        intent.putExtra(TAG, priceEntity)
        startActivity(intent)
        dismiss()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val TAG = "BottomSheetPurchaseBasket"
    }
}
