package com.adityadavin.sample.presentation.recylerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.adityadavin.sample.R
import com.adityadavin.sample.databinding.ItemUsersBinding
import com.adityadavin.sample.presentation.recylerview.adapter.UserAdapter.UserViewHolder
import com.adityadavin.sample.presentation.recylerview.model.User
import com.adityadavin.sunshine.utils.ext.onClick
import com.adityadavin.sunshine.utils.ext.setImageUrl
import com.adityadavin.sunshine.utils.recyclerview.adapter.BaseRecyclerViewAdapter
import com.adityadavin.sunshine.utils.recyclerview.adapter.BaseRecyclerViewHolder

class UserAdapter(
    mContext: Context,
    list: List<User>,
    private val onItemClick: ((User) -> Unit)?
) : BaseRecyclerViewAdapter<User, UserViewHolder>(mContext, list) {

    override fun getViewBinding(parent: ViewGroup?, viewType: Int): ViewBinding =
        ItemUsersBinding.inflate(LayoutInflater.from(mContext), parent, false)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(mContext, getViewBinding(parent, viewType))

    inner class UserViewHolder(mContext: Context, binding: ViewBinding) : BaseRecyclerViewHolder<User>(mContext, binding) {

        override fun bind(data: User) {
            with(mBinding as ItemUsersBinding) {
                tvName.text = data.name
                data.image?.let { imgAvatar.setImageUrl(mContext, url = it, placeholderRes = R.drawable.ic_launcher_background) }

                root.onClick {
                    onItemClick?.invoke(itemList[adapterPosition])
                }
            }
        }
    }
}