package com.loc.newsapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImp(
    private val context:Context
): LocalUserManager {

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { pre ->
            pre[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

    override suspend fun saveAppEntry() {
        context.dataStore.edit { s->
            s[PreferencesKeys.APP_ENTRY] = true
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}