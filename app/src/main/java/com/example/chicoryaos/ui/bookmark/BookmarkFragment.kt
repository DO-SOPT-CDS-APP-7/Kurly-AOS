import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chicoryaos.databinding.BottomSheetFragmentBookmarkBasketBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookmarkFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentBookmarkBasketBinding? = null
    private val binding: BottomSheetFragmentBookmarkBasketBinding
        get() = requireNotNull(_binding)

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
    }

    companion object {
        const val TAG = "BottomSheetBookmark"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
