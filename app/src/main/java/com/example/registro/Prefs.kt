package com.example.registro

import android.content.Context

class Prefs (val context:Context){
    val DATABASE = "MyDB"
    val FULL_NAME = "Fullname"
    val NAME="name"
    val EMAIL= "Email"
    val PASSWORD="Password"
    val RePASSWORD="RePassword"
    val GENERO= "Género"
    val storage = context.getSharedPreferences(DATABASE, Context.MODE_PRIVATE)

    fun saveFullName(Fullname:String){
        storage.edit().putString(FULL_NAME, Fullname).apply()
    }

    fun saveName(name: String){
        storage.edit().putString(NAME, name).apply()
    }

    fun getFullName():String{
        return storage.getString(FULL_NAME, "")!!
    }

    fun getName():String{
        return storage.getString(NAME, "")!!
    }
    fun saveEmail(Email:String){
        storage.edit().putString(EMAIL, Email).apply()
    }

    fun savePassword(Password:String){
        storage.edit().putString(PASSWORD, Password).apply()
    }

    fun getEmail():String{
        return storage.getString(EMAIL, "")!!
    }

    fun getPassword():String{
        return storage.getString(PASSWORD, "")!!
    }
    fun savePassword2(Password:String){
        storage.edit().putString(RePASSWORD, Password).apply()
    }
    fun getPassword2():String{
        return storage.getString(RePASSWORD, "")!!
    }
    fun saveGender(Gender:String){
        storage.edit().putString(GENERO, Gender).apply()
    }
    fun getGender():String{
        return storage.getString(GENERO, "")!!
    }
    fun wipeData(){
        storage.edit().clear().apply()
    }
}