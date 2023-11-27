package com.example.chicoryaos.ui.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.chicoryaos.databinding.BottomSheetFragmentPurchaseBasketBinding
import com.example.chicoryaos.util.extensions.AnimateProgressBar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseBasketFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentPurchaseBasketBinding? = null
    private val binding: BottomSheetFragmentPurchaseBasketBinding
        get() = requireNotNull(_binding)

    private val viewModel: PurchaseViewModel by activityViewModels()

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
        initProgressAnimation()
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
    }

    private fun initProgressAnimation() {
        val progressBar = binding.pgBasket
        val anim =
            AnimateProgressBar(progressBar, 0f, (viewModel.purchaseProgress.value ?: 0).toFloat())
        anim.duration = 1500
        progressBar.startAnimation(anim)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val TAG = "BottomSheetPurchaseBasket"
    }
}
