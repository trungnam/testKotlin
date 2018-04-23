package com.hydraz.trungnam1992.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.hydraz.trungnam1992.myapplication.di.AppComponent
import com.hydraz.trungnam1992.myapplication.di.DaggerAppComponent

/**
 * Created by trungnam1992 on 4/24/18.
 */


class App : MultiDexApplication() {
//
//    private var context: Context? = null
//    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent


    }





}
