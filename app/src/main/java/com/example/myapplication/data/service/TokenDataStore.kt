package com.example.myapplication.data.service

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("auth_prefs")

class TokenDataStore (private val context: Context){
    private val TOKEN_KEY = stringPreferencesKey("auth_token")

    suspend fun saveToken(token: String){
        context.dataStore.edit { prefs -> prefs[TOKEN_KEY] = token}
    }

    suspend fun getToken(): String? = context.dataStore.data
        .map{it[TOKEN_KEY]}
        .first()
}