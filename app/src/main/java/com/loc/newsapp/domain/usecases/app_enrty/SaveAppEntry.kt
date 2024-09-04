package com.loc.newsapp.domain.usecases.app_enrty

import com.loc.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserMng: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserMng.saveAppEntry()
    }
}