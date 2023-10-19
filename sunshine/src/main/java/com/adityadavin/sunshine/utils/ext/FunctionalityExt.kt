package com.adityadavin.sunshine.utils.ext

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Toast

/**
 * Formatting
 */

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Int.sp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        toFloat(),
        Resources.getSystem().displayMetrics
    )

/* End of Formatting */

/**
 * Action
 */

fun View.onClick(action: (View) -> Unit) {
    setOnClickListener(action)
}

fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/* End of Action */

/**
 * Logger
 */

fun d(tag: String, message: String?) {
    Log.d(tag, message.toString())
}

/* End of Logger */