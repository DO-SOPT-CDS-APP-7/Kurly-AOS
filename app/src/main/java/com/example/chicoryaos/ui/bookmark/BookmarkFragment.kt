import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.chicoryaos.databinding.BottomSheetFragmentBookmarkBinding
import com.example.chicoryaos.ui.bookmark.BookmarkAdapter
import com.example.chicoryaos.ui.bookmark.BookmarkViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookmarkFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetFragmentBookmarkBinding? = null
    private val binding: BottomSheetFragmentBookmarkBinding
        get() = requireNotNull(_binding)

    private lateinit var viewModel: BookmarkViewModel
    private lateinit var bookmarkAdapter: BookmarkAdapter

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

        viewModel = ViewModelProvider(this).get(BookmarkViewModel::class.java)
        bookmarkAdapter = BookmarkAdapter(requireContext())

        binding.rvWishListOtherConsumerItem.adapter = bookmarkAdapter
        binding.rvWishListPurchaseWithItem.adapter = bookmarkAdapter

        viewModel.bookmarkList.observe(viewLifecycleOwner, { bookmarkList ->
            bookmarkAdapter.setBookmarkList(bookmarkList)
        })
    }

    companion object {
        const val TAG = "BottomSheetBookmark"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
