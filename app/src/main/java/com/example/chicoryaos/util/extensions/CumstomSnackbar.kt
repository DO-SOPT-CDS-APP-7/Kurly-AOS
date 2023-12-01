package com.example.chicoryaos.util

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.chicoryaos.R
import com.google.android.material.snackbar.Snackbar

class CustomBookmarkSnackbar {

    companion object {

        private var currentSnackbar: Snackbar? = null

        fun showBookmarkAddSnackbar(anchorView: View, context: Context) {
            showSnackbar(
                anchorView,
                context,
                R.layout.snackbar_bookmark_add,
            )
        }

        fun showBookmarkDeleteSnackbar(anchorView: View, context: Context) {
            showSnackbar(
                anchorView,
                context,
                R.layout.snackbar_bookmark_delete,
            )
        }

        fun dismissSnackbar() {
            currentSnackbar?.dismiss()
        }

        private fun showSnackbar(
            anchorView: View,
            context: Context,
            layoutId: Int,
        ) {
            val customSnackbarView = LayoutInflater.from(context).inflate(layoutId, null)
            val snackbar = Snackbar.make(anchorView, "", Snackbar.LENGTH_LONG)
            val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

            val params = snackbarLayout.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(0, 0, 0, 50)
            snackbarLayout.layoutParams = params

            snackbarLayout.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    android.R.color.transparent,
                ),
            )

            val customParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
            )
            snackbarLayout.addView(customSnackbarView, 0, customParams)

            snackbarLayout.setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_UP -> {
                        snackbar.dismiss()
                    }
                }
                true
            }

            currentSnackbar = snackbar

            snackbar.show()
        }
    }
}
