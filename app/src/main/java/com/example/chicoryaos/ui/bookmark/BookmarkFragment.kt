import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.chicoryaos.databinding.BottomSheetFragmentBookmarkBasketBinding
import com.example.chicoryaos.ui.bookmark.BookmarkViewModel
import com.example.chicoryaos.util.CustomBookmarkSnackbar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookmarkFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentBookmarkBasketBinding? = null
    private val binding: BottomSheetFragmentBookmarkBasketBinding
        get() = requireNotNull(_binding)

    private val bookmarkViewModel by activityViewModels<BookmarkViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = BottomSheetFragmentBookmarkBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataBinding()
        CustomBookmarkSnackbar.showBookmarkAddSnackbar(binding.root, requireContext())
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // BottomSheet 상태 변경 감지
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        // BottomSheet이 드래그 중인 상태
                        CustomBookmarkSnackbar.dismissSnackbar()
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // BottomSheet이 슬라이딩 중인 상태
            }
        })

        return dialog
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = bookmarkViewModel
    }

    companion object {
        const val TAG = "BottomSheetBookmark"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
