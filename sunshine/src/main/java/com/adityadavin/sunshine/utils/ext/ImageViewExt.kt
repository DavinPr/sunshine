package com.adityadavin.sunshine.utils.ext

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageResource(context: Context, resId: Int, isCenterCrop: Boolean = false) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
    }
    Glide.with(context)
        .load(resId).apply(options).into(this)
}

fun ImageView.setImageResource(context: Context, resId: Int, placeholderRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
    }
    Glide.with(context)
        .load(resId).apply(options).into(this)
}

fun ImageView.setImageResource(context: Context, resId: Int, placeholderDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
    }
    Glide.with(context)
        .load(resId).apply(options).into(this)
}

fun ImageView.setImageResource(context: Context, resId: Int, placeholderRes: Int, errorRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
        error(errorRes)
    }
    Glide.with(context)
        .load(resId).apply(options).into(this)
}

fun ImageView.setImageResource(context: Context, resId: Int, placeholderDrawable: Drawable?, errorRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
        error(errorRes)
    }
    Glide.with(context)
        .load(resId).apply(options).into(this)
}

fun ImageView.setImageResource(context: Context, resId: Int, placeholderRes: Int, errorDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
        error(errorDrawable)
    }
    Glide.with(context)
        .load(resId).apply(options).into(this)
}

fun ImageView.setImageResource(context: Context, resId: Int, placeholderDrawable: Drawable?, errorDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
        error(errorDrawable)
    }
    Glide.with(context).load(resId).apply(options).into(this)
}

fun ImageView.setImageDrawable(context: Context, drawable: Drawable?, isCenterCrop: Boolean = false) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
    }
    Glide.with(context)
        .load(drawable).apply(options).into(this)
}

fun ImageView.setImageDrawable(context: Context, drawable: Drawable?, placeholderRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
    }
    Glide.with(context)
        .load(drawable).apply(options).into(this)
}

fun ImageView.setImageDrawable(context: Context, drawable: Drawable?, placeholderDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
    }
    Glide.with(context)
        .load(drawable).apply(options).into(this)
}

fun ImageView.setImageDrawable(context: Context, drawable: Drawable?, placeholderRes: Int, errorRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
        error(errorRes)
    }
    Glide.with(context)
        .load(drawable).apply(options).into(this)
}

fun ImageView.setImageDrawable(context: Context, drawable: Drawable?, placeholderDrawable: Drawable?, errorRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
        error(errorRes)
    }
    Glide.with(context)
        .load(drawable).apply(options).into(this)
}

fun ImageView.setImageDrawable(context: Context, drawable: Drawable?, placeholderRes: Int, errorDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
        error(errorDrawable)
    }
    Glide.with(context)
        .load(drawable).apply(options).into(this)
}

fun ImageView.setImageDrawable(context: Context, drawable: Drawable?, placeholderDrawable: Drawable?, errorDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
        error(errorDrawable)
    }
    Glide.with(context).load(drawable).apply(options).into(this)
}

fun ImageView.setImageUrl(context: Context, url: String, isCenterCrop: Boolean = false) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
    }
    Glide.with(context)
        .load(url).apply(options).into(this)
}

fun ImageView.setImageUrl(context: Context, url: String, placeholderRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
    }
    Glide.with(context)
        .load(url).apply(options).into(this)
}

fun ImageView.setImageUrl(context: Context, url: String, placeholderDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
    }
    Glide.with(context)
        .load(url).apply(options).into(this)
}

fun ImageView.setImageUrl(context: Context, url: String, placeholderRes: Int, errorRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
        error(errorRes)
    }
    Glide.with(context)
        .load(url).apply(options).into(this)
}

fun ImageView.setImageUrl(context: Context, url: String, placeholderDrawable: Drawable?, errorRes: Int, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
        error(errorRes)
    }
    Glide.with(context)
        .load(url).apply(options).into(this)
}

fun ImageView.setImageUrl(context: Context, url: String, placeholderRes: Int, errorDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderRes)
        error(errorDrawable)
    }
    Glide.with(context)
        .load(url).apply(options).into(this)
}

fun ImageView.setImageUrl(context: Context, url: String, placeholderDrawable: Drawable?, errorDrawable: Drawable?, isCenterCrop: Boolean = false, ) {
    val options = RequestOptions().apply {
        if (isCenterCrop) centerCrop()
        placeholder(placeholderDrawable)
        error(errorDrawable)
    }
    Glide.with(context).load(url).apply(options).into(this)
}


