package com.adityadavin.sunshine.presentation.view

import android.content.Context
import android.graphics.Bitmap.Config
import android.graphics.Bitmap.Config.ARGB_8888
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView.ScaleType.CENTER_CROP
import androidx.appcompat.widget.AppCompatImageView

class CircleImageView : AppCompatImageView {

    companion object {

        val BITMAP_CONFIG: Config = ARGB_8888

        const val COLORDRAWABLE_DIMENSION: Int = 2

        const val DEFAULT_BORDER_COLOR: Int = Color.BLACK

        const val DEFAULT_BORDER_OVERLAY: Boolean = false

        const val DEFAULT_BORDER_WIDTH: Int = 0

        val SCALE_TYPE: ScaleType = CENTER_CROP
    }

    var borderColor: Int = DEFAULT_BORDER_COLOR
        set(value) {
            if (field != value) {
                field = value

                invalidate()
            }
        }

    var isDisableCircularTransformation: Boolean = false
        set(value) {
            if (field != value) {
                field = value
//                initializedBitmap()
            }
        }

    var borderWith: Int = 0
        set(value) {
            if (field != value) {
                field = value
//                setup()
            }
        }

    var borderOverlay: Boolean = false
        set(value) {
            if (field != value) {
                field = value
//                setup()
            }
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val radius = measuredHeight / 2.toFloat()
//        canvas?.drawCircle(radius, radius, radius, drawable)
    }
}