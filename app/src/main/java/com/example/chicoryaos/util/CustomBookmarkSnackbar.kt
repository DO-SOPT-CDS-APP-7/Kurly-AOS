import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.chicoryaos.R
import com.google.android.material.snackbar.Snackbar

class CustomBookmarkSnackbar {

    companion object {

        fun showBookmarkAddSnackbar(view: View, context: Context) {
            showSnackbar(
                view,
                context,
                R.layout.snackbar_bookmark_add,
                R.string.snackbar_bookmark_plus_ment,
                R.string.snackbar_bookmark_go_ment,
            )
        }

        fun showBookmarkDeleteSnackbar(view: View, context: Context) {
            showSnackbar(
                view,
                context,
                R.layout.snackbar_bookmark_delete,
                R.string.snackbar_bookmark_delete_ment,
            )
        }

        private fun showSnackbar(
            view: View,
            context: Context,
            layoutId: Int,
            vararg stringResourceIds: Int,
        ) {
            val customSnackbarView = LayoutInflater.from(context).inflate(layoutId, null)
            val snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
            val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

            val marginParams = snackbarLayout.layoutParams as ViewGroup.MarginLayoutParams
            marginParams.setMargins(0, 0, 0, 50)
            snackbarLayout.layoutParams = marginParams

            val textView =
                snackbarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.visibility = View.INVISIBLE

            snackbarLayout.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    android.R.color.transparent,
                ),
            )

            val params = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
            )
            snackbarLayout.addView(customSnackbarView, 0, params)

            for ((index, stringResourceId) in stringResourceIds.withIndex()) {
                val textViewId = when (index) {
                    0 -> R.id.tv_snackbar_bookmark_plus_ment
                    1 -> R.id.tv_snackbar_bookmark_go_ment
                    else -> R.id.tv_snackbar_bookmark_delete_ment
                }
                val customTextView = customSnackbarView.findViewById<TextView>(textViewId)
                customTextView?.text = context.getString(stringResourceId)
            }

            snackbar.show()
        }
    }
}
