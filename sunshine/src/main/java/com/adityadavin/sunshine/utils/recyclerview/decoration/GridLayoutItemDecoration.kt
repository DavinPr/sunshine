package com.adityadavin.sunshine.utils.recyclerview.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adityadavin.sunshine.utils.ext.px

class GridLayoutItemDecoration(
    private val spanCount: Int,
    private val spacing: Int,
    private val orientation: Int = GridLayoutManager.VERTICAL,
    private val edgeSpacing: Int? = null
) : RecyclerView.ItemDecoration() {

    private fun getFirstItemOfTheLineValue(positionModValue: Int): Int {
        return (spacing - positionModValue * spacing / spanCount).px
    }

    private fun getLastItemOfTheLineValue(positionModValue: Int): Int {
        return ((positionModValue + 1) * spacing / spanCount).px
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val positionModValue = position % spanCount

        outRect.apply {
            parent.adapter?.let { adapter ->

                if (orientation == GridLayoutManager.VERTICAL) {
                    val highestCompleteRow: Int = adapter.itemCount.minus(1) / spanCount

                    if (edgeSpacing != null) {
                        when {
                            spanCount == 1 -> {
                                left = edgeSpacing.px
                                right = edgeSpacing.px
                            }
                            //first item of the row
                            position.plus(1).mod(spanCount) == 1 -> {
                                left = edgeSpacing.px
                                right = getLastItemOfTheLineValue(positionModValue)
                            }
                            //last item of the row
                            position.plus(1).mod(spanCount) == 0 -> {
                                left = getFirstItemOfTheLineValue(positionModValue)
                                right = edgeSpacing.px
                            }
                            else -> {
                                left = getFirstItemOfTheLineValue(positionModValue)
                                right = getLastItemOfTheLineValue(positionModValue)
                            }
                        }

                        //first row items
                        if (position < spanCount) top = edgeSpacing.px

                        //last row items
                        bottom = if (position + 1 > spanCount * highestCompleteRow)
                            edgeSpacing.px
                        else
                            spacing.px
                    } else {
                        when {
                            spanCount == 1 -> {
                                left = spacing.px
                                right = spacing.px
                            }
                            //first item of the row
                            position.plus(1).mod(spanCount) == 1 -> {
                                left = spacing.px
                                right = getLastItemOfTheLineValue(positionModValue)
                            }
                            //last item of the row
                            position.plus(1).mod(spanCount) == 0 -> {
                                left = getFirstItemOfTheLineValue(positionModValue)
                                right = spacing.px
                            }
                            else -> {
                                left = getFirstItemOfTheLineValue(positionModValue)
                                right = getLastItemOfTheLineValue(positionModValue)
                            }
                        }
                        if (position < spanCount) top = spacing.px  //first row items
                        bottom = spacing.px
                    }
                } else {
                    val highestCompleteColumn: Int = adapter.itemCount.minus(1) / spanCount
                    if (edgeSpacing != null) {
                        when {
                            spanCount == 1 -> {
                                top = edgeSpacing.px
                                bottom = edgeSpacing.px
                            }
                            //first item of the column
                            position.plus(1).mod(spanCount) == 1 -> {
                                top = edgeSpacing.px
                                bottom = getLastItemOfTheLineValue(positionModValue)
                            }
                            //last item of the column
                            position.plus(1).mod(spanCount) == 0 -> {
                                top = getFirstItemOfTheLineValue(positionModValue)
                                bottom = edgeSpacing.px
                            }
                            else -> {
                                top = getFirstItemOfTheLineValue(positionModValue)
                                bottom = getLastItemOfTheLineValue(positionModValue)
                            }
                        }

                        //first column items
                        if (position < spanCount) left = edgeSpacing.px
                        //last column items
                        right = if (position + 1 > spanCount * highestCompleteColumn)
                            edgeSpacing.px
                        else
                            spacing.px
                    } else {
                        when {
                            spanCount == 1 -> {
                                top = spacing.px
                                bottom = spacing.px
                            }
                            //first item of the column
                            position.plus(1).mod(spanCount) == 1 -> {
                                top = spacing.px
                                bottom = getLastItemOfTheLineValue(positionModValue)
                            }
                            //last item of the column
                            position.plus(1).mod(spanCount) == 0 -> {
                                top = getFirstItemOfTheLineValue(positionModValue)
                                bottom = spacing.px
                            }
                            else -> {
                                top = getFirstItemOfTheLineValue(positionModValue)
                                bottom = getLastItemOfTheLineValue(positionModValue)
                            }
                        }
                        if (position < spanCount) left = spacing.px     //first column items

                        right = spacing.px
                    }
                }
            }
        }
    }
}