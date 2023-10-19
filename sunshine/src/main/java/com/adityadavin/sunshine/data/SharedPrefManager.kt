package com.adityadavin.sunshine.data

interface SharedPrefManager {

    fun clear()

    fun getBoolean(key: String, default: Boolean): Boolean

    fun getFloat(key: String, default: Float): Float

    fun getInt(key: String, default: Int): Int

    fun getLong(key: String, default: Long): Long

    fun <T> getObject(key: String, type: Class<T>): T?

    fun getString(key: String, default: String): String

    fun setBoolean(key: String, value: Boolean)

    fun setFloat(key: String, value: Float)

    fun setInt(key: String, value: Int)

    fun setLong(key: String, value: Long)

    fun setObject(key: String, value: Any)

    fun setString(key: String, value: String)
}