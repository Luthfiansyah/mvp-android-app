package com.jalanesia.mytrip.utils

import android.content.Context
import android.util.Log
import com.jalanesia.mytrip.SessionManager
import com.jalanesia.mytrip.data.auth.LoginResponse

class Auth {

    fun isLogin(context: Context) :Boolean {

        var sessionManager = SessionManager(context)
        Log.e("Session", sessionManager.fetchAuthToken().toString())

        if (sessionManager.fetchAuthToken() == null){
            return false
        }
        return true
    }

    fun setSession(context: Context, token: String){
        var sessionManager = SessionManager(context)
        sessionManager.saveAuthToken(token)
    }
}