package com.adityadavin.sunshine.utils.recyclerview.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adityadavin.sunshine.utils.ext.px

class LinearLayoutItemDecoration(
    private val spacing: Int,
    private val orientation: Int = LinearLayoutManager.VERTICAL,
    private val edgeSpacing: Int? = null
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        outRect.apply {
            parent.adapter?.let { adapter ->
                if (orientation == LinearLayoutManager.VERTICAL) {
                    if (edgeSpacing != null) {
                        when (position) {
                            0 -> top = edgeSpacing.px
                            adapter.itemCount.minus(1) -> {
                                top = spacing.px
                                bottom = edgeSpacing.px
                            }
                            else -> top = spacing.px
                        }
                    } else {
                        top = spacing.px
                        if (position == adapter.itemCount.minus(1)) bottom = spacing.px
                    }
                } else {
                    if (edgeSpacing != null) {
                        when (position) {
                            0 -> left = edgeSpacing.px
                            adapter.itemCount.minus(1) -> {
                                left = spacing.px
                                right = edgeSpacing.px
                            }
                            else -> left = spacing.px
                        }
                    } else {
                        left = spacing.px
                        if (position == adapter.itemCount.minus(1)) right = spacing.px
                    }
                }
            }
        }
    }
}
