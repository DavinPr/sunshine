package com.adityadavin.sample.presentation.recylerview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id : Int? = null,
    val image : String? = null,
    val name : String? = null
) : Parcelable
