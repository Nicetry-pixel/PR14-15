package com.example.myapplication.data.service

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val TOKEN_KEY = stringPreferencesKey("auth_token")

object TokenDataStore{
    private val Context.dataStore by preferencesDataStore("auth_prefs")
    private var appContext: Context? = null

    fun init (context: Context){
        appContext = context.applicationContext
    }

    suspend fun saveToken(token: String){
        appContext?.dataStore?.edit { prefs -> prefs[TOKEN_KEY] = token}
    }

    suspend fun getToken(): String? = appContext?.dataStore?.data?.first()?.get(TOKEN_KEY)
}