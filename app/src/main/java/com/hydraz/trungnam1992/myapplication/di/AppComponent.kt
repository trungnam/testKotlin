package com.hydraz.trungnam1992.myapplication.di

import com.hydraz.trungnam1992.myapplication.ui.view.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by trungnam1992 on 4/24/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
public interface AppComponent{

    fun inject(activity: MainActivity)

}