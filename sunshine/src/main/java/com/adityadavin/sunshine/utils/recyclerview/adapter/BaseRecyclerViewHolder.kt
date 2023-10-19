package com.adityadavin.sunshine.utils.recyclerview.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewHolder<Data>(protected val mContext: Context, protected val mBinding: ViewBinding) :
    RecyclerView.ViewHolder(mBinding.root) {

    abstract fun bind(data: Data)
}