package com.hydraz.trungnam1992.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.hydraz.trungnam1992.myapplication.di.AppComponent
import com.hydraz.trungnam1992.myapplication.di.DaggerAppComponent
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by trungnam1992 on 4/24/18.
 */


class App : MultiDexApplication() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
        lateinit var realmConfiguration : RealmConfiguration
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()

        //set up Realm
        Realm.init(this)
        realmConfiguration = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }



}
