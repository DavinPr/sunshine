package com.adityadavin.sunshine.utils.recyclerview.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<Data, VH : BaseRecyclerViewHolder<Data>>(context: Context) :
    RecyclerView.Adapter<VH>() {

    protected var mContext: Context
    private var _itemList: ArrayList<Data>
    val itemList: List<Data> get() = _itemList

    init {
        mContext = context
        _itemList = arrayListOf()
    }

    constructor(context: Context, items: List<Data>) : this(context) {
        this.mContext = context
        this._itemList.addAll(items)
    }

    abstract fun getViewBinding(parent: ViewGroup?, viewType: Int): ViewBinding

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun add(data: Data) {
        _itemList.add(data)
        notifyItemInserted(this.itemList.lastIndex)
    }

    fun addAll(datas: List<Data>) {
        if (datas.isNotEmpty()) {
            val tmpLastIndex = itemList.lastIndex
            _itemList.addAll(datas)
            notifyItemRangeChanged(tmpLastIndex + 1, itemList.size)
        }
    }

    fun update(data: Data): Int {
        val indexOfData = itemList.indexOf(data)
        if (indexOfData < 0) return 0
        _itemList[indexOfData] = data
        notifyItemChanged(indexOfData)
        return 1
    }

    fun addOrUpdate(data: Data) {
        val indexOfData = itemList.indexOf(data)
        if (indexOfData >= 0) {
            _itemList[indexOfData] = data
            notifyItemChanged(indexOfData)
        } else {
            add(data)
        }
    }

    fun addOrUpdate(datas: List<Data>) {
        for (data in datas) {
            val indexOfData = itemList.indexOf(data)
            if (indexOfData >= 0) {
                _itemList[indexOfData] = data
                notifyItemChanged(indexOfData)
            } else {
                add(data)
            }
        }
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        if (position in itemList.indices) {
            _itemList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun remove(data: Data) {
        remove(itemList.indexOf(data))
    }

    fun clear() {
        _itemList.clear()
        notifyDataSetChanged()
    }
}