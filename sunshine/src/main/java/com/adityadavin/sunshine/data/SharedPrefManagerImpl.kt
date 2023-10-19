package com.adityadavin.sunshine.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPrefManagerImpl(
    private val context: Context,
    private val prefName: String,
    private val gson: Gson
) : SharedPrefManager {

    private val mPreference: SharedPreferences by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun clear() = mPreference.edit().clear().apply()

    override fun getBoolean(key: String, default: Boolean): Boolean = mPreference.getBoolean(key, default)

    override fun getFloat(key: String, default: Float): Float = mPreference.getFloat(key, default)

    override fun getInt(key: String, default: Int): Int = mPreference.getInt(key, default)

    override fun getLong(key: String, default: Long): Long = mPreference.getLong(key, default)

    override fun <T> getObject(key: String, type: Class<T>): T? {
        val json = mPreference.getString(key, "") ?: return null
        return gson.fromJson(json, type)
    }

    override fun getString(key: String, default: String): String = mPreference.getString(key, default) ?: default

    override fun setBoolean(key: String, value: Boolean) = mPreference.edit().putBoolean(key, value).apply()

    override fun setFloat(key: String, value: Float) = mPreference.edit().putFloat(key, value).apply()

    override fun setInt(key: String, value: Int) = mPreference.edit().putInt(key, value).apply()

    override fun setLong(key: String, value: Long) = mPreference.edit().putLong(key, value).apply()

    override fun setObject(key: String, value: Any) {
        val json = gson.toJson(value)
        mPreference.edit().putString(key, json).apply()
    }

    override fun setString(key: String, value: String) = mPreference.edit().putString(key, value).apply()
}